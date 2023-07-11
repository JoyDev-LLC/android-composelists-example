package com.composelists.ui.screens.rotation_and_color_changing_animation

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun RotationAndColorChangingAnimationScreen() {
    val infinityAnimation = rememberInfiniteTransition()
    val rotationAnimation by infinityAnimation.animateFloat(
        initialValue = 0f, targetValue = 360f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000)
        )
    )
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier.graphicsLayer {
                    rotationZ = rotationAnimation
                }
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color.Red)
                        .size(60.dp)
                )
            }
        }
    }
}
