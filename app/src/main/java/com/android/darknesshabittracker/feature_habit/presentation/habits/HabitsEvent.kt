package com.android.darknesshabittracker.feature_habit.presentation.habits

import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.util.HabitOrder

sealed class HabitsEvent {
    data class Order(val order: HabitOrder) : HabitsEvent()
    data class DeleteHabit(val habit: Habit) : HabitsEvent()
    data object RestoreHabit : HabitsEvent()
    data object ToggleOrderSection : HabitsEvent()

}