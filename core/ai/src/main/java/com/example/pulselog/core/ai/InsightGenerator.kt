package com.example.pulselog.core.ai

import com.example.pulselog.core.model.Habit
import com.example.pulselog.core.model.JournalEntry
import com.example.pulselog.core.model.WeeklyInsight

/**
 * Common contract for generating weekly reflective insights from habit and journal data.
 */
interface InsightGenerator {
    suspend fun generateWeeklyInsight(
        habits: List<Habit>,
        journalEntries: List<JournalEntry>
    ): WeeklyInsight
}
