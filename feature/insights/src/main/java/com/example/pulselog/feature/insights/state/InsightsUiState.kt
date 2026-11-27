package com.example.pulselog.feature.insights.state

import com.example.pulselog.core.model.WeeklyInsight

sealed interface InsightsUiState {
    object Loading : InsightsUiState
    data class Success(
        val insight: WeeklyInsight? = null,
        val isGenerating: Boolean = false
    ) : InsightsUiState
    data class Error(val message: String) : InsightsUiState
}
