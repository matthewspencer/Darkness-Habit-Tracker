package com.android.darknesshabittracker.data.repository

import com.android.darknesshabittracker.core.model.Habit

interface HabitRepository {
    suspend fun getHabits(): List<Habit>
    suspend fun createHabit(habit: Habit)
    suspend fun updateHabit(habit: Habit)
    suspend fun deleteHabit(habit: Habit)
}