package com.example.myandroidbook.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val buttonLight = Color(0xFF997B66)
val buttonDark = Color(0xFFF9A826)

val buttonContentLight = Color(0xFFF0EAD2)
val buttonContentDark = Color(0xFF3D405B)

val activeDarkIndicator = Color(0xFFF9A826)
val activeLightIndicator = Color(0xFF997B66)

val inactiveDarkIndicator = Color(0xFFAEB2D5)
val inactiveLightIndicator = Color(0xFFC1C1C1)

val onBoardingLightTitle = Color(0xFF997B66)
val onBoardingDarkTitle = Color(0xFFF9A826)

val onBoardingDarkDes = Color(0xFFD7D7D7)
val onBoardingLightDes = Color(0xFF997B66)

val welcomeLight = Color(0xFFEDE0D4)
val welcomeDark = Color(0xFF2E3043)

val topBarContentLight = Color(0xFF997B66)
val topBarContentDark = Color(0xFFBEC3E7)

val topBarBackgroundLight = Color(0xFFFFEDE0D4)
val topBarBackgroundDark = Color(0xFF2E3043)

val iconLightSearch = Color(0xFF997B66)
val iconDarkSearch = Color(0xFFBEC3E7)

val starColor = Color(0xFFFFBB33)

val Colors.buttonColor
get() = if (isLight) buttonLight else buttonDark

val Colors.buttonContentColor
get() = if (isLight) buttonContentLight else buttonContentDark

val Colors.pagerIndicatorActive
get() = if (isLight) activeLightIndicator else activeDarkIndicator

val Colors.pagerIndicatorInactive
get() = if (isLight) inactiveLightIndicator else inactiveDarkIndicator

val Colors.onBoardingThemesBackground
get() = if (isLight) welcomeLight else welcomeDark

val Colors.titleOnBoarding
get() = if (isLight) onBoardingLightTitle else onBoardingDarkTitle

val Colors.descriptionOnBoarding
get() = if (isLight) onBoardingLightDes else onBoardingDarkDes

val Colors.topBarContent
get() = if (isLight) topBarContentLight else topBarContentDark

val Colors.topBarBackground
get() = if (isLight) topBarBackgroundLight else topBarBackgroundDark

val Colors.searchIcon
get() = if (isLight) iconLightSearch else iconDarkSearch
