package com.example.pulselog.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pulselog.core.model.JournalEntry
import com.example.pulselog.core.model.MoodScore
import java.time.Instant
import java.time.LocalDate

@Entity(tableName = "journal_entries")
data class JournalEntryEntity(
    @PrimaryKey
    val id: String,
    val dateEpochDay: Long,
    val moodScoreValue: Int,
    val reflection: String,
    val createdAtEpochMilli: Long
) {
    fun toDomain(): JournalEntry = JournalEntry(
        id = id,
        date = LocalDate.ofEpochDay(dateEpochDay),
        moodScore = MoodScore.fromValue(moodScoreValue),
        reflection = reflection,
        createdAt = Instant.ofEpochMilli(createdAtEpochMilli)
    )

    companion object {
        fun fromDomain(entry: JournalEntry): JournalEntryEntity = JournalEntryEntity(
            id = entry.id,
            dateEpochDay = entry.date.toEpochDay(),
            moodScoreValue = entry.moodScore.value,
            reflection = entry.reflection,
            createdAtEpochMilli = entry.createdAt.toEpochMilli()
        )
    }
}
