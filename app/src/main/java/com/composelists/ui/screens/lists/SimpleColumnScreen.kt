package com.composelists.ui.screens.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleColumnScreen() {
   Column(
       modifier = Modifier.fillMaxSize()
   ) {
       repeat(10) { value ->
           SimpleItemView(text = value.toString())
       }
   }
}