package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes
import java.util.*

@Composable
fun Welcome(isDarkTheme: Boolean, navController: NavController) {
    val backgroundRes = if (isDarkTheme) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome
    val logo = if (isDarkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            imageVector = ImageVector.vectorResource(id = backgroundRes),
            contentDescription = "welcome background",
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = logo),
                contentDescription = "logo",
                tint = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(72.dp)
            ) {
                Text(
                    text = "Sign up".toUpperCase(Locale.ROOT),
                    color = MaterialTheme.colors.onPrimary,
                    style = MaterialTheme.typography.button,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navController.navigate(route = ScreenState.Login)
                },
                shape = shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .height(72.dp)
            ) {
                Text(
                    text = "Log in".toUpperCase(Locale.ROOT),
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.button,
                )
            }

        }
    }
}