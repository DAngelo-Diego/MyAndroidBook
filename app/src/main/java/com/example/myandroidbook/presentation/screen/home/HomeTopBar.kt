package com.example.myandroidbook.presentation.screen.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.myandroidbook.R
import com.example.myandroidbook.ui.theme.searchIcon
import com.example.myandroidbook.ui.theme.topBarBackground
import com.example.myandroidbook.ui.theme.topBarContent

@Composable
fun HomeTopBar( onSearchClicked: ()-> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topBarContent
            )
        },
        backgroundColor = MaterialTheme.colors.topBarBackground,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(imageVector = Icons.Default.Search, contentDescription = stringResource(R.string.search_icon), tint = MaterialTheme.colors.searchIcon)
            }
        }
    )
}