package com.example.pulselog.feature.dashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulselog.core.ui.component.PulseCompletionRing
import com.example.pulselog.core.ui.component.PulseLogButton
import com.example.pulselog.feature.dashboard.state.DashboardUiState

@Composable
fun DashboardRoute(
    onNavigateToJournal: () -> Unit,
    onNavigateToInsights: () -> Unit,
    modifier: Modifier = Modifier
) {
    DashboardScreen(
        uiState = DashboardUiState.Success(
            habits = emptyList(),
            completedCount = 0,
            totalCount = 0,
            streakSummary = "Ready to start your streak!"
        ),
        onToggleHabit = {},
        onNavigateToJournal = onNavigateToJournal,
        onNavigateToInsights = onNavigateToInsights,
        modifier = modifier
    )
}

@Composable
fun DashboardScreen(
    uiState: DashboardUiState,
    onToggleHabit: (String) -> Unit,
    onNavigateToJournal: () -> Unit,
    onNavigateToInsights: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            Text(
                text = "Today's Pulse",
                style = MaterialTheme.typography.headlineMedium
            )

            PulseCompletionRing(
                progress = 0f,
                centerText = "0%"
            )

            PulseLogButton(
                text = "Open Micro-Journal",
                onClick = onNavigateToJournal
            )

            PulseLogButton(
                text = "View Insights",
                onClick = onNavigateToInsights
            )
        }
    }
}
