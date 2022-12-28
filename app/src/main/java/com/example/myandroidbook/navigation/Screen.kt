package com.example.myandroidbook.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
    object Details : Screen("details_screen/{androidId}") {
        fun passAndroidId(androidId: Int): String {
            return "details_screen/$androidId"
        }
    }

    object Search : Screen("search_screen")
}