package com.example.pulselog.core.database.repository

import com.example.pulselog.core.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    fun getHabitsStream(): Flow<List<Habit>>
    suspend fun getHabit(id: String): Habit?
    suspend fun upsertHabit(habit: Habit)
    suspend fun deleteHabit(habit: Habit)
    suspend fun toggleHabitCompletion(id: String)
}
