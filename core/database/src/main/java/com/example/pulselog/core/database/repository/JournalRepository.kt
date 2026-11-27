package com.example.pulselog.core.database.repository

import com.example.pulselog.core.model.JournalEntry
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow

interface JournalRepository {
    fun getJournalEntriesStream(): Flow<List<JournalEntry>>
    suspend fun getEntryForDate(date: LocalDate): JournalEntry?
    suspend fun saveJournalEntry(entry: JournalEntry)
    suspend fun deleteJournalEntry(entry: JournalEntry)
}
