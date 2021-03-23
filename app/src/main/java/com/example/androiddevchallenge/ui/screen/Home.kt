package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.Favorite
import com.example.androiddevchallenge.ui.data.bodyList
import com.example.androiddevchallenge.ui.data.favoriteList
import com.example.androiddevchallenge.ui.data.mindList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import java.util.Locale

@Composable
fun Home(isDarkTheme: Boolean) {
    val searchState = remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomActionBar()
        },
        floatingActionButton = {
            Fab()
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        Content(searchState)
    }
}

@Composable
private fun Content(searchState: MutableState<String>) {
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
        Title("favorite collections")
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 8.dp)
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
        Title("align your body")
        RowBody()
        Title("align your mind")
        RowMind()
        Spacer(
            Modifier
                .navigationBarsHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title.toUpperCase(Locale.ROOT),
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h2,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp)
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp)
    )
}

@Composable
fun RowBody() {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        for (item in bodyList) {
            item {
                Course(
                    painter = painterResource(id = item.res),
                    title = item.name,
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun RowMind() {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp)
    ) {
        for (item in mindList) {
            item {
                Course(
                    painter = painterResource(id = item.res),
                    title = item.name,
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Course(
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = title,
            modifier = Modifier
                .size(88.dp)
                .clip(RoundedCornerShape(percent = 50)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            modifier = Modifier.paddingFromBaseline(top = 24.dp),
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
private fun Fab() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = MaterialTheme.colors.primary,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24),
            contentDescription = stringResource(id = R.string.cd_action_play)
        )
    }
}

@Composable
private fun BottomActionBar() {
    BottomAppBar(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 6.dp
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                SmallIcon(resId = R.drawable.ic_baseline_spa_24)
            },
            label = {
                Text(stringResource(id = R.string.cd_nav_home).toUpperCase(Locale.ROOT))
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                SmallIcon(resId = R.drawable.ic_baseline_account_circle_24)
            },
            label = {
                Text(stringResource(id = R.string.cd_nav_profile).toUpperCase(Locale.ROOT))
            }
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

@Composable
fun SmallIcon(resId: Int) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = stringResource(id = R.string.cd_nav_profile),
        modifier = Modifier.size(18.dp)
    )
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