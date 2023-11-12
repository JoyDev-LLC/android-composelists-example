package com.composelists.ui.screens.lists

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.composelists.mock.users

@Composable
fun ExpandedLazyColumnScreen() {
    val users by remember { mutableStateOf(users) }
    var clickedItemId by remember { mutableStateOf(Int.MIN_VALUE) }
    Box {
        LazyColumn {
            items(users, key = { user -> user.id }) { user ->
                PersonView_For_Expanded(
                    id = user.id,
                    name = user.name,
                    onItemClick = { id ->
                        clickedItemId =
                            if (clickedItemId == id) Int.MIN_VALUE
                            else id
                    },
                    expandedItemId = clickedItemId
                )
            }
        }
    }
}
