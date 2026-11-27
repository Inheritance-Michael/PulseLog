package com.example.pulselog.core.model

import java.time.LocalDate

/**
 * Domain model representing a weekly AI or rule-based reflection summary.
 */
data class WeeklyInsight(
    val id: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val summaryText: String,
    val motivationalQuote: String,
    val generatedByAi: Boolean,
    val topHabitName: String? = null
)
