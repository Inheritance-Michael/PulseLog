package com.example.pulselog.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pulselog.core.model.Habit
import com.example.pulselog.core.model.HabitCategory
import java.time.Instant

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val colorHex: String,
    val currentStreak: Int,
    val bestStreak: Int,
    val isCompletedToday: Boolean,
    val createdAtEpochMilli: Long
) {
    fun toDomain(): Habit = Habit(
        id = id,
        title = title,
        description = description,
        category = runCatching { HabitCategory.valueOf(category) }.getOrDefault(HabitCategory.HEALTH),
        colorHex = colorHex,
        currentStreak = currentStreak,
        bestStreak = bestStreak,
        isCompletedToday = isCompletedToday,
        createdAt = Instant.ofEpochMilli(createdAtEpochMilli)
    )

    companion object {
        fun fromDomain(habit: Habit): HabitEntity = HabitEntity(
            id = habit.id,
            title = habit.title,
            description = habit.description,
            category = habit.category.name,
            colorHex = habit.colorHex,
            currentStreak = habit.currentStreak,
            bestStreak = habit.bestStreak,
            isCompletedToday = habit.isCompletedToday,
            createdAtEpochMilli = habit.createdAt.toEpochMilli()
        )
    }
}
