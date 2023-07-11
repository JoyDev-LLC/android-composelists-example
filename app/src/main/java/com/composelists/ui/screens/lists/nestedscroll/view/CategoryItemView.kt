package com.composelists.ui.screens.lists.nestedscroll.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composelists.model.Category

@Composable
fun CategoryItemView(category: Category, modifier: Modifier = Modifier) {
    Text(
        text = category.name,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(
            items = category.subcategories,
            key = { subcategory -> subcategory.id }
        ) { subcategory ->
            SubcategoryItemView(
                subcategory = subcategory,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .padding(top = 8.dp, bottom = 6.dp, end = 8.dp),
            )
        }
    }
}
