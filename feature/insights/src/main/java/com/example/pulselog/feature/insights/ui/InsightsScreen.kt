package com.example.pulselog.feature.insights.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulselog.core.ui.component.PulseLogButton
import com.example.pulselog.feature.insights.state.InsightsUiState

@Composable
fun InsightsRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    InsightsScreen(
        uiState = InsightsUiState.Success(),
        onGenerateSummary = {},
        onBackClick = onBackClick,
        modifier = modifier
    )
}

@Composable
fun InsightsScreen(
    uiState: InsightsUiState,
    onGenerateSummary: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Weekly Insights",
                style = MaterialTheme.typography.headlineMedium
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "AI Reflection Summary",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Review your habit consistency and weekly reflections here.",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            PulseLogButton(
                text = "Generate Reflection",
                onClick = onGenerateSummary
            )

            PulseLogButton(
                text = "Back",
                onClick = onBackClick
            )
        }
    }
}
