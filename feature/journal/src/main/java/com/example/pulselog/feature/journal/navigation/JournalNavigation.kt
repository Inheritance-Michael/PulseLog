package com.example.pulselog.feature.journal.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.pulselog.feature.journal.ui.JournalRoute
import kotlinx.serialization.Serializable

@Serializable
object JournalRoute

fun NavController.navigateToJournal(navOptions: NavOptions? = null) {
    navigate(route = JournalRoute, navOptions = navOptions)
}

fun NavGraphBuilder.journalScreen(
    onBackClick: () -> Unit
) {
    composable<JournalRoute> {
        JournalRoute(onBackClick = onBackClick)
    }
}
