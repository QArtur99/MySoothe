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

data class Body(val name: String, val res: Int)

val bodyList = listOf(
    Body("Inversions", R.drawable.pexels_2),
    Body("Quick yoga", R.drawable.pexels_1),
    Body("Stretching", R.drawable.pexels_3),
    Body("Tabata", R.drawable.pexels_6),
    Body("HIIT", R.drawable.pexels_16),
    Body("Pre-natural yoga", R.drawable.pexels_7),
)
