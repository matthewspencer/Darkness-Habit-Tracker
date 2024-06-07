package com.android.darknesshabittracker.feature_habit.domain.repository

import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {

    fun getHabits(): Flow<List<Habit>>
    fun createHabit(habit: Habit)
    suspend fun deleteHabit(habit: Habit)
}