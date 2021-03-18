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