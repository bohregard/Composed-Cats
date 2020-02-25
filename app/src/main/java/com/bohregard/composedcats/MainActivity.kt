package com.bohregard.composedcats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.bohregard.composedcats.model.CatObject
import com.bohregard.composedcats.model.Screen
import com.bohregard.composedcats.model.Status
import com.bohregard.composedcats.ui.CatContent
import com.bohregard.composedcats.ui.HomeContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val catObjects = (1..20).toList().map { CatObject(index = it) }
        setContent {
            MaterialTheme {
                Crossfade(current = Status.currentScreen) {
                    when (it) {
                        is Screen.Home -> {
                            HomeContent(catObjects = catObjects)
                        }
                        is Screen.CatScreen -> {
                            CatContent(int = Status.currentCat)
                        }
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        when (Status.currentScreen) {
            is Screen.Home -> super.onBackPressed()
            else -> Status.currentScreen = Screen.Home
        }
    }
}