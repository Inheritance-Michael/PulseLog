package com.example.pulselog.feature.journal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pulselog.core.ui.component.PulseLogButton
import com.example.pulselog.feature.journal.state.JournalUiState

@Composable
fun JournalRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    JournalScreen(
        uiState = JournalUiState.Success(),
        onSaveReflection = { _, _ -> },
        onBackClick = onBackClick,
        modifier = modifier
    )
}

@Composable
fun JournalScreen(
    uiState: JournalUiState,
    onSaveReflection: (String, Int) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var reflectionText by remember { mutableStateOf("") }

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Daily Micro-Journal",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedTextField(
                value = reflectionText,
                onValueChange = { if (it.length <= 280) reflectionText = it },
                label = { Text("How was your day? (Max 280 chars)") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 4
            )

            PulseLogButton(
                text = "Save Reflection",
                onClick = { onSaveReflection(reflectionText, 3) }
            )

            PulseLogButton(
                text = "Back",
                onClick = onBackClick
            )
        }
    }
}
