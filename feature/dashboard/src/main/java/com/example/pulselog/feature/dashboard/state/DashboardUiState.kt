package com.example.pulselog.feature.dashboard.state

import com.example.pulselog.core.model.Habit

sealed interface DashboardUiState {
    object Loading : DashboardUiState
    data class Success(
        val habits: List<Habit> = emptyList(),
        val completedCount: Int = 0,
        val totalCount: Int = 0,
        val streakSummary: String = ""
    ) : DashboardUiState
    data class Error(val message: String) : DashboardUiState
}
