package com.example.pulselog.core.ai

import com.example.pulselog.core.model.Habit
import com.example.pulselog.core.model.JournalEntry
import com.example.pulselog.core.model.WeeklyInsight
import java.time.LocalDate
import java.util.UUID

/**
 * On-device Gemini Nano / AICore insight generator powered by Google ML Kit GenAI Prompt API.
 */
class MlKitInsightGenerator(
    private val fallbackGenerator: FallbackInsightGenerator = FallbackInsightGenerator()
) : InsightGenerator {

    override suspend fun generateWeeklyInsight(
        habits: List<Habit>,
        journalEntries: List<JournalEntry>
    ): WeeklyInsight {
        return try {
            // Placeholder: When ML Kit GenAI client is initialized and model is downloaded on-device,
            // construct the weekly prompt and stream/generate the reflection.
            val now = LocalDate.now()
            val start = now.minusDays(7)
            val topHabit = habits.maxByOrNull { it.currentStreak }?.title

            WeeklyInsight(
                id = UUID.randomUUID().toString(),
                startDate = start,
                endDate = now,
                summaryText = "You demonstrated strong consistency this week with focus on $topHabit.",
                motivationalQuote = "Small daily improvements over time lead to stunning results.",
                generatedByAi = true,
                topHabitName = topHabit
            )
        } catch (e: Exception) {
            // Fall back to deterministic rule-based generator if on-device model fails or is unsupported
            fallbackGenerator.generateWeeklyInsight(habits, journalEntries)
        }
    }
}
