package com.composelists.ui.screens.lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composelists.mock.users
import com.composelists.model.TitleItem
import com.composelists.model.User

@Composable
fun SimpleLazyColumnScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100000) { value ->
            SimpleItemView(text = value.toString())
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun `SimpleLazyColumnScreen_With_animateItemPlacement`() {
    LazyColumn {
        items(users, key = { user -> user.id }) { user ->
            PersonView(
                name = user.name, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .animateItemPlacement()
            )
        }
    }
}

@Composable
fun SimpleLazyRowScreen() {
    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(100000) { value ->
            SimpleItemView(text = value.toString())
        }
    }
}

@Composable
fun SimpleLazyColumnScreen(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            PersonView(name = user.name, modifier = Modifier)
        }
    }
}

@Composable
fun `Another_SimpleLazyColumnScreen`(users: List<User>) {
    LazyColumn {
        item {
            TitleItem()
        }
        itemsIndexed(users) { index, user ->
            PersonView(name = user.name)
        }
        items(users) { user ->
            PersonView(name = user.name)
        }
    }
}

@Composable
fun `SimpleLazyColumnScreen_With_Buttons_But_Bad_Practice`() {
    var users by remember { mutableStateOf(users) }
    Box {
        LazyColumn {
            items(users) { user ->
                PersonView(name = user.name)
            }
        }
        Row {
            Button(onClick = {
                users = users.toMutableList().also {
                    it.add(0, User(123, "123"))
                }
            }) {
                Text(text = "Add")
            }
            Button(onClick = { users = users.drop(1) }) {
                Text(text = "Remove")
            }
            Button(onClick = { users = users.shuffled() })
            {
                Text(text = "Shuffle")
            }
        }
    }
}

@Composable
fun `SimpleLazyColumnScreen_With_Buttons_And_Key`() {
    var users by remember { mutableStateOf(users) }
    Box {
        LazyColumn {
            items(users, key = { user -> user.id }) { user ->
                PersonView(name = user.name)
            }
        }
        Row {
            Button(onClick = {
                users = users.toMutableList().also {
                    it.add(0, User(123, "123"))
                }
            }) {
                Text(text = "Add")
            }
            Button(onClick = { users = users.drop(1) }) {
                Text(text = "Remove")
            }
            Button(onClick = { users = users.shuffled() })
            {
                Text(text = "Shuffle")
            }
        }
    }
}

@Composable
fun ScrollableLazyList(users: List<User>) {
    val listState = rememberLazyListState()
    var isAtTheEndOfList by remember(listState) {
        mutableStateOf(false)
    }
    Box {
        LazyColumn(state = listState) {
            items(users, key = { user -> user.id })
            { user ->
                PersonView(name = user.name)
            }
        }
        LaunchedEffect(listState.layoutInfo) {
            isAtTheEndOfList =
                listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1

        }
        if (isAtTheEndOfList) Text(text = "Конец списка", modifier = Modifier.align(Alignment.BottomCenter), fontSize = 22.sp)
    }
}

@Composable
fun `ScrollableLazyList_With_Correct_logic`(users: List<User>) {
    val listState = rememberLazyListState()
    val isAtTheEndOfList by remember(listState) {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1
        }
    }
    Box {
        LazyColumn(state = listState) {
            items(users, key = { user -> user.id })
            { user ->
                PersonView(name = user.name)
            }
        }
        if (isAtTheEndOfList) Text(text = "Конец списка", modifier = Modifier.align(Alignment.BottomCenter), fontSize = 22.sp)
    }
}

