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