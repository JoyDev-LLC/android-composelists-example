package com.composelists.ui.screens.padding_offset_aspect_ratio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PaddingOffsetAspectRatioScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            ) {
                Text(
                    text = "This text has equal padding of 16dp in all directions",
                    modifier = Modifier.padding(16.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
            ) {
                Text(
                    text = "32 start, 4 end, 32 top and 0 bottom paddings",
                    modifier = Modifier.padding(start = 32.dp, top = 32.dp, end = 4.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
            ) {
                Text(
                    text = "Text without padding, but we have offset 18 dp X. Some text. Some text. Some text. Some text. Some text. Some text. Some text.",
                    modifier = Modifier.offset(18.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
            ) {
                Text(
                    text = "Aspect ratio 16:9",
                    modifier = Modifier.aspectRatio(16f / 9f)
                )
            }
        }
    }
}
