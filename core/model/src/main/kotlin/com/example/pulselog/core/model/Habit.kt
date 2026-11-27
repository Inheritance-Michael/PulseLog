package com.example.pulselog.core.model

import java.time.Instant

/**
 * Domain model representing a habit to track.
 */
data class Habit(
    val id: String,
    val title: String,
    val description: String = "",
    val category: HabitCategory = HabitCategory.HEALTH,
    val colorHex: String = "#4285F4",
    val currentStreak: Int = 0,
    val bestStreak: Int = 0,
    val isCompletedToday: Boolean = false,
    val createdAt: Instant = Instant.now()
)

enum class HabitCategory {
    HEALTH,
    MINDFULNESS,
    PRODUCTIVITY,
    FITNESS,
    LEARNING,
    OTHER
}
