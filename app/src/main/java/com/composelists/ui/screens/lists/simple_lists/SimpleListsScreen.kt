package com.composelists.ui.screens.lists.simple_lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composelists.mock.users
import com.composelists.model.User
import com.composelists.ui.screens.lists.simple_lists.view.PersonView
import kotlin.random.Random

@Composable
fun SimpleColumnScreen(users: List<User>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        users.forEach { user ->
            PersonView(name = user.name, modifier = Modifier)
        }
    }
}

@Composable
fun SimpleRowScreen(users: List<User>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(state = rememberScrollState())
    ) {
        users.forEach { user ->
            PersonView(name = user.name, modifier = Modifier)
        }
    }
}

/*@Composable
fun SimpleLazyColumnScreen() {
    val users by remember { mutableStateOf(users) }
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        items(users, key = { user -> user.id }) { user ->
            PersonView(name = user.name)
        }
    }
    val shouldScrollToTop by remember {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1
        }
    }
    LaunchedEffect(shouldScrollToTop) {
        if (shouldScrollToTop) listState.scrollToItem(0)
    }
}*/

/*@Composable
fun ScrollableLazyList(users: List<User>) {
    val listState = rememberLazyListState()
    val isAtTheEndOfList by remember(listState) {
        derivedStateOf {
            listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1
        }
    }
    Box {
        LazyColumn(state = listState) {
            items(users, key = { user -> user.id }) { user ->
                PersonView(name = user.name)
            }
        }
        if (isAtTheEndOfList) Text(text = "Конец списка", modifier = Modifier.align(Alignment.BottomCenter), fontSize = 22.sp)
    }
}*/


@Composable
fun ScrollableLazyList(users: List<User>) {
    val listState = rememberLazyListState()
    var isAtTheEndOfList by remember(listState) {
        mutableStateOf(false)
    }
    Box {
        LazyColumn(state = listState) {
            items(users, key = { user -> user.id }) { user ->
                PersonView(name = user.name, modifier = Modifier)
            }
        }
        LaunchedEffect(listState.layoutInfo) {
            isAtTheEndOfList =
                listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == listState.layoutInfo.totalItemsCount - 1
        }
        if (isAtTheEndOfList) Text(text = "Конец списка", modifier = Modifier.align(Alignment.BottomCenter), fontSize = 22.sp)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleLazyColumnScreen() {
    var users by remember { mutableStateOf(users) }
    Box {
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
        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                users = users.toMutableList().also { it.add(3, User(Random.nextInt(), "New item")) }
            }) {
                Text(text = "Add")
            }
            Button(onClick = { users = users.drop(1) }) {
                Text(text = "Remove")
            }
            Button(onClick = { users = users.shuffled() }) {
                Text(text = "Shuffle")
            }
        }
    }
}

@Composable
fun ExpandedLazyColumnScreen() {
    val users by remember { mutableStateOf(users) }
    var clickedItemId by remember { mutableStateOf(Int.MIN_VALUE) }
    Box {
        LazyColumn {
            items(users, key = { user -> user.id }) { user ->
                PersonView(
                    id = user.id,
                    name = user.name,
                    onItemClick = { id -> clickedItemId = if (clickedItemId == id) Int.MIN_VALUE else id },
                    showAdditionalText = clickedItemId == user.id,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}

/*@Composable
fun SimpleLazyColumnScreen() {
    val users by remember { mutableStateOf(users) }
    LazyColumn {
        items(users) { user ->
            PersonView(name = user.name)
        }
    }
}*/

@Composable
fun SimpleLazyRowScreen() {
    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(10000) { value ->
            PersonView(name = value.toString(), modifier = Modifier)
        }
    }
}