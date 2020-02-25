package com.bohregard.composedcats.model

import androidx.compose.Model

sealed class Screen {
    object Home: Screen()
    data class CatScreen(val cat: Int): Screen()
}
@Model
object Status {
    var currentCat: Int = -1
    var currentScreen: Screen = Screen.Home
}
fun navigateTo(destination: Screen) {
    Status.currentScreen = destination
}