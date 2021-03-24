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
package com.example.androiddevchallenge.ui.data

import com.example.androiddevchallenge.R

data class Favorite(val name: String, val res: Int)

val favoriteList = listOf(
    Favorite("Short mantras", R.drawable.pexels_18),
    Favorite("Nature meditations", R.drawable.pexels_12),
    Favorite("Stress and anxiety", R.drawable.pexels_9),
    Favorite("Self-massage", R.drawable.pexels_14),
    Favorite("Overwhelmed", R.drawable.pexels_13),
    Favorite("Nightly wind down", R.drawable.pexels_8),
)
