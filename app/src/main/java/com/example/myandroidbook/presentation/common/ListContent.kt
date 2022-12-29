package com.example.myandroidbook.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import com.example.myandroidbook.domain.model.AndroidModel
import com.example.myandroidbook.navigation.Screen
import com.example.myandroidbook.ui.theme.ANDROID_ITEM_HEIGHT
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myandroidbook.R
import com.example.myandroidbook.presentation.components.RankingDifficulty
import com.example.myandroidbook.ui.theme.Shapes
import com.example.myandroidbook.ui.theme.topBarContent
import com.example.myandroidbook.util.Constant.BASE_URL

@Composable
fun ListContent(
    languages: LazyPagingItems<AndroidModel>,
    navController: NavHostController
) {

}

@Composable
fun AndroidItem(
    language: AndroidModel,
    navController: NavHostController
) {


    Box(modifier = Modifier
        .height(ANDROID_ITEM_HEIGHT)
        .clickable {
            navController.navigate(Screen.Details.passAndroidId(androidId = language.id))
        },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = Shapes.large) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = "$BASE_URL${language.image}")
                    .placeholder(drawableResId = R.drawable.placeholder)
                    .error(drawableResId = R.drawable.placeholder)
                    .build(),
                contentDescription = stringResource(id = R.string.language_image),
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Blue.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Text(
                    text = language.title,
                    color = MaterialTheme.colors.topBarContent,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = language.about,
                    color = MaterialTheme.colors.topBarContent,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RankingDifficulty(
                        modifier = Modifier.padding(end = 10.dp),
                        ranking = language.ranking
                    )
                    Text(
                        text = "(${language.ranking})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun LanguageItemPreview(){
    AndroidItem(language = AndroidModel(
        id = 1,
        title = "Jetpack Compose",
        image = "",
        about = "It’s a recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code. \n",
        ranking = 3.5,
        difficulty = "medium",
        tags = listOf(),
        yearRelease = "2020"
    ), navController = rememberNavController())
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun LanguageDarkItemPreview(){
    AndroidItem(language = AndroidModel(
        id = 1,
        title = "Jetpack Compose",
        image = "",
        about = "It’s a recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code. \n",
        ranking = 3.5,
        difficulty = "medium",
        tags = listOf(),
        yearRelease = "2020"
    ), navController = rememberNavController())
}