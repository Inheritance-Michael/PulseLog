package com.example.pulselog.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.pulselog.feature.dashboard.ui.DashboardRoute
import kotlinx.serialization.Serializable

@Serializable
object DashboardRoute

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    navigate(route = DashboardRoute, navOptions = navOptions)
}

fun NavGraphBuilder.dashboardScreen(
    onNavigateToJournal: () -> Unit,
    onNavigateToInsights: () -> Unit
) {
    composable<DashboardRoute> {
        DashboardRoute(
            onNavigateToJournal = onNavigateToJournal,
            onNavigateToInsights = onNavigateToInsights
        )
    }
}
