package com.composelists.ui.screens.lists

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonView(
    modifier: Modifier = Modifier,
    id: Int = 0,
    name: String,
    onItemClick: (Int) -> Unit = {},
    expandedItemId: Int? = null
) {
    val rotation = animateFloatAsState(targetValue = if (id == expandedItemId) 180f else 0f)
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(pressedElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                modifier = Modifier
                    .align(CenterVertically)
                    .graphicsLayer(
                        rotationZ = rotation.value
                    )
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { onItemClick(id) }
                    )
            )
        }
        AnimatedVisibility(visible = id == expandedItemId) {
            Text(
                text = "Additional text",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun `PersonView_For_Expanded`(
    id: Int,
    name: String,
    onItemClick: (Int) -> Unit,
    expandedItemId: Int
) {
    val rotation = animateFloatAsState(targetValue = if (id == expandedItemId) 180f else 0f)
    Card {
        Row {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                modifier = Modifier
                    .align(CenterVertically)
                    .graphicsLayer(
                        rotationZ = rotation.value
                    )
                    .clickable { onItemClick(id) }
            )
        }
        AnimatedVisibility(visible = id == expandedItemId) {
            Text(
                text = "Additional text",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun `Simple_PersonView`(name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier.align(CenterVertically)
            )
        }
    }
}