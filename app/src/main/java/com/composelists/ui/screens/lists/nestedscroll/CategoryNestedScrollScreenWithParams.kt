package com.composelists.ui.screens.lists.nestedscroll

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composelists.mock.categories
import com.composelists.model.Category
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryNestedScrollScreenWithParams() {
    Surface(modifier = Modifier.fillMaxSize()) {
        var categories by remember {
            mutableStateOf(categories)
        }
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(color = MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Title", style = MaterialTheme.typography.titleLarge, color = Color.White)
                }
            }) { paddingValues ->
            CategoryNestedScrollView(
                categories = categories,
                onDeleteClick = {
                    categories = categories.drop(1)
                },
                onAddClick = {
                    categories = categories + Category(
                        categories.last().id.plus(1),
                        Random.nextInt().toString(),
                        categories.last().subcategories.shuffled()
                    )
                },
                onShuffleNamesClick = {
                    val newList = categories.map { category ->
                        val name = category.name.toCharArray().apply {
                            shuffle()
                        }.joinToString("")
                        category.copy(name = name)
                    }
                    categories = newList
                },
                onShuffleClick = {
                    categories = categories.shuffled()
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding())
            )
        }
    }
}
