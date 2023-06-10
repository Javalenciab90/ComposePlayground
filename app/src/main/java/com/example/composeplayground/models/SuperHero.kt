package com.example.composeplayground.models

import androidx.annotation.DrawableRes

data class SuperHero(
    val heroName: String,
    val realName: String,
    val publisher: String,
    @DrawableRes val photo: Int
)
