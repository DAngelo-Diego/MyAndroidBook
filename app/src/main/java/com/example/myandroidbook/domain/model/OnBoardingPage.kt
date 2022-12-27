package com.example.myandroidbook.domain.model

import androidx.annotation.DrawableRes
import com.example.myandroidbook.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.first,
        title = "Road to Knowledge",
        description = "Learn with the last and best examples from the official documents"
    )

    object Second : OnBoardingPage(
        image = R.drawable.second,
        title = "Take Notes",
        description = "Take some notes and share it with everyone"
    )

    object Third : OnBoardingPage(
        image = R.drawable.third,
        title = "Easy Remember",
        description = "With this book you will be ready to start creating projects"
    )
}
