package com.example.proyectoandroid

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUI() {
        composeTestRule.setContent {
            ComparisonScreen()
        }

        // Interact with the UI using composeTestRule.onNode and perform actions
        // Check UI states using composeTestRule.onNode and assertions
    }
}
