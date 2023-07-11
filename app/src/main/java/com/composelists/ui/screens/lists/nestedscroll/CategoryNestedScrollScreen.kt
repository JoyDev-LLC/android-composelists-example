package com.composelists.ui.screens.lists.nestedscroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composelists.mock.categories
import com.composelists.model.Category
import com.composelists.ui.screens.lists.nestedscroll.view.CategoryItemView

@Composable
@Preview(showBackground = true)
fun NestedScrollViewPreview() {
    CategoryNestedScrollView(categories, {}, {}, {}, {})
}

@Composable
fun CategoryNestedScrollView(
    categories: List<Category>,
    onAddClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onShuffleNamesClick: () -> Unit,
    onShuffleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyColumn(contentPadding = PaddingValues(bottom = 60.dp)) {
            items(
                items = categories,
                key = { category -> category.id }
            ) { category ->
                CategoryItemView(category = category, modifier = Modifier.padding(start = 10.dp))
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = onAddClick,
                modifier = Modifier.widthIn(min = 60.dp),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Text(text = "Add")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = onDeleteClick,
                modifier = Modifier.widthIn(min = 60.dp),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Text(text = "Delete")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = onShuffleNamesClick,
                modifier = Modifier.widthIn(min = 60.dp),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Text(text = "Shuffle Names")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = onShuffleClick,
                modifier = Modifier.widthIn(min = 60.dp),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
            ) {
                Text(text = "Shuffle")
            }
            Spacer(modifier = Modifier.width(6.dp))
        }
    }
}
