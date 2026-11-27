package com.example.pulselog.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pulselog.core.database.dao.HabitDao
import com.example.pulselog.core.database.dao.JournalEntryDao
import com.example.pulselog.core.database.entity.HabitEntity
import com.example.pulselog.core.database.entity.JournalEntryEntity

@Database(
    entities = [
        HabitEntity::class,
        JournalEntryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PulseLogDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun journalEntryDao(): JournalEntryDao
}
