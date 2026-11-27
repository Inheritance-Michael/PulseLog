package com.example.pulselog.core.model

import java.time.Instant
import java.time.LocalDate

/**
 * Domain model representing a micro-journal entry and mood score.
 */
data class JournalEntry(
    val id: String,
    val date: LocalDate,
    val moodScore: MoodScore,
    val reflection: String,
    val createdAt: Instant = Instant.now()
)

enum class MoodScore(val value: Int) {
    VERY_LOW(1),
    LOW(2),
    NEUTRAL(3),
    GOOD(4),
    GREAT(5);

    companion object {
        fun fromValue(value: Int): MoodScore = entries.firstOrNull { it.value == value } ?: NEUTRAL
    }
}
