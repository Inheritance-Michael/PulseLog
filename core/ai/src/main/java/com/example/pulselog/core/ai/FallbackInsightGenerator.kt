package com.example.pulselog.core.ai

import com.example.pulselog.core.model.Habit
import com.example.pulselog.core.model.JournalEntry
import com.example.pulselog.core.model.WeeklyInsight
import java.time.LocalDate
import java.util.UUID

/**
 * Deterministic rule-based fallback generator for devices lacking NPU hardware or offline Gemini Nano support.
 */
class FallbackInsightGenerator : InsightGenerator {

    override suspend fun generateWeeklyInsight(
        habits: List<Habit>,
        journalEntries: List<JournalEntry>
    ): WeeklyInsight {
        val now = LocalDate.now()
        val start = now.minusDays(7)

        val completedHabitsCount = habits.count { it.isCompletedToday }
        val topHabit = habits.maxByOrNull { it.currentStreak }

        val summary = when {
            habits.isEmpty() -> "Start tracking your first habit to unlock personalized insights."
            completedHabitsCount > 0 -> "Great momentum today! You kept up with your habits including ${topHabit?.title ?: "your daily goals"}."
            else -> "Every new day is a fresh opportunity to build lasting consistency."
        }

        return WeeklyInsight(
            id = UUID.randomUUID().toString(),
            startDate = start,
            endDate = now,
            summaryText = summary,
            motivationalQuote = "Consistency is the DNA of mastery.",
            generatedByAi = false,
            topHabitName = topHabit?.title
        )
    }
}
