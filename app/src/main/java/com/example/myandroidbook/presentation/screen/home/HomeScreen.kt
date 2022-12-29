package com.example.myandroidbook.presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.myandroidbook.presentation.common.ListContent
import com.example.myandroidbook.presentation.components.RankingDifficulty
import kotlinx.serialization.json.JsonNull.content

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), navController: NavHostController
) {

    val getAllAndroidInfo = homeViewModel.getAllAndroidInfo.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            ListContent(languages = getAllAndroidInfo, navController = navController )
        }
    )

}

