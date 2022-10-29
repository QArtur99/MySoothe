/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.data.ScreenState
import com.example.androiddevchallenge.ui.theme.shapes
import java.util.Locale

@Composable
fun Login(isDarkTheme: Boolean, navController: NavController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    val backgroundRes = if (isDarkTheme) R.drawable.ic_dark_login else R.drawable.ic_light_login
    val logo = if (isDarkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.TopCenter
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
            Box(
                modifier = Modifier.height(200.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "log in".toUpperCase(Locale.ROOT),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h1,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = {
                    Text(
                        text = "Email address",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),

                value = emailState.value,
                onValueChange = { passwordState.value = it },
                label = {
                    Text(
                        text = "Password",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    navController.navigate(route = ScreenState.Home)
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
            Box(
                modifier = Modifier.height(32.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row {
                    Text(
                        text = "Don't have account?",
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Sign up",
                        color = MaterialTheme.colors.onBackground,
                        textDecoration = TextDecoration.Underline,
                        style = MaterialTheme.typography.body1,
                    )
                }
            }
        }
    }
}
