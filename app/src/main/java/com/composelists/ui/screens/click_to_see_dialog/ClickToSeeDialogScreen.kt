package com.composelists.ui.screens.click_to_see_dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ClickToSeeDialogScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        var isDialogVisible by remember {
            mutableStateOf(false)
        }
        Box(contentAlignment = Alignment.Center) {
            Button(onClick = { isDialogVisible = !isDialogVisible }) {
                Text(text = "Click to see dialog")
            }
        }
        if (isDialogVisible)
            AlertDialog(
                onDismissRequest = { isDialogVisible = false },
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                confirmButton = {

                },

                /*
                {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column {
                            Text(text = "Congratulations!")
                            Button(onClick = { isDialogVisible = false }) {
                                Text(text = "Close me")
                            }
                        }
                    }
                }
                 */
            )
    }
}
