package com.example.pulselog.feature.journal.state

import com.example.pulselog.core.model.JournalEntry
import com.example.pulselog.core.model.MoodScore

sealed interface JournalUiState {
    object Loading : JournalUiState
    data class Success(
        val entries: List<JournalEntry> = emptyList(),
        val selectedMood: MoodScore = MoodScore.NEUTRAL,
        val currentReflection: String = ""
    ) : JournalUiState
    data class Error(val message: String) : JournalUiState
}
