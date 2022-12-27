package com.example.myandroidbook.presentation.screen.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier, topBar = {
        HomeTopBar(
            onSearchClicked = {}
        )
    }) {

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}