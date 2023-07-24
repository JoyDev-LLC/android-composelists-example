package com.composelists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.composelists.mock.users
import com.composelists.ui.screens.lists.simple_lists.SimpleColumnScreen
import com.composelists.ui.screens.lists.simple_lists.SimpleLazyColumnScreen
import com.composelists.ui.screens.lists.simple_lists.SimpleRowScreen
import com.composelists.ui.theme.ComposelistsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposelistsTheme {
                /*SimpleRowScreen(users)
                SimpleColumnScreen(users)*/
                SimpleLazyColumnScreen()
            }
        }
    }
}
