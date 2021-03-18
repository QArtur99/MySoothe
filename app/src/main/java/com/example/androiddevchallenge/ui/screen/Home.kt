package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.Favorite
import com.example.androiddevchallenge.ui.data.favoriteList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import java.util.Locale

@Composable
fun Home(isDarkTheme: Boolean) {
    val searchState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background),
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            value = searchState.value,
            onValueChange = { searchState.value = it },
            label = {
                Row {
                    Icon(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = "logo",
                        tint = MaterialTheme.colors.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "Search",
                        color = MaterialTheme.colors.onBackground,
                        style = MaterialTheme.typography.body1,
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            )
        )
        Box(
            modifier = Modifier
                .height(40.dp)
                .padding(start = 16.dp, end = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "favorite collections".toUpperCase(Locale.ROOT),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h2,
            )
        }
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ) {
            for (i in favoriteList.indices step 2) {
                Column {
                    ItemFavorite(item = favoriteList[i])
                    Spacer(Modifier.height(8.dp))
                    ItemFavorite(item = favoriteList[i + 1])
                }
                Spacer(Modifier.width(8.dp))
            }
        }
        Spacer(
            Modifier
                .navigationBarsHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
fun ItemFavorite(item: Favorite) {
    Card(shape = shapes.small) {
        Row(
            modifier = Modifier
                .background(color = MaterialTheme.colors.surface)
                .height(56.dp)
                .width(192.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(56.dp)
                    .width(56.dp),
                painter = painterResource(item.res),
                contentScale = ContentScale.Crop,
                contentDescription = item.name
            )
            Spacer(Modifier.width(18.dp))
            Text(
                text = item.name,
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h3,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme(darkTheme = false) {
        ProvideWindowInsets {
            Home(false)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        ProvideWindowInsets {
            Home(true)
        }
    }
}