package com.android.darknesshabittracker.core.use_case

import com.android.darknesshabittracker.core.model.Habit

interface CreateHabitUseCase {
    suspend fun createHabit(habit: Habit)
}