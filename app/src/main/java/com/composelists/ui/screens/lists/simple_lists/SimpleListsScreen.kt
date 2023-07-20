package com.composelists.ui.screens.lists.simple_lists

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.composelists.mock.users
import com.composelists.model.User
import com.composelists.ui.screens.lists.simple_lists.view.PersonView

@Composable
fun SimpleColumnScreen(users: List<User>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        users.forEach { user ->
            PersonView(name = user.name)
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
            PersonView(name = user.name)
        }
    }
}

@Composable
fun SimpleLazyColumnScreen(users: List<User>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10000) { value ->
            PersonView(name = value.toString())
        }
    }
}

@Composable
fun SimpleLazyColumnScreen() {
    val users by remember { mutableStateOf(users) }
    LazyColumn {
        items(users) { user ->
            PersonView(name = user.name)
        }
    }
}

@Composable
fun SimpleLazyRowScreen() {
    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(10000) { value ->
            PersonView(name = value.toString())
        }
    }
}