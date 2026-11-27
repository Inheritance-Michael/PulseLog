package com.example.pulselog.feature.insights.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.pulselog.feature.insights.ui.InsightsRoute
import kotlinx.serialization.Serializable

@Serializable
object InsightsRoute

fun NavController.navigateToInsights(navOptions: NavOptions? = null) {
    navigate(route = InsightsRoute, navOptions = navOptions)
}

fun NavGraphBuilder.insightsScreen(
    onBackClick: () -> Unit
) {
    composable<InsightsRoute> {
        InsightsRoute(onBackClick = onBackClick)
    }
}
