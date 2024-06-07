package com.android.darknesshabittracker.feature_habit.presentation.habits

import androidx.room.Index
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.util.HabitOrder
import com.android.darknesshabittracker.feature_habit.domain.util.OrderType
import kotlinx.coroutines.flow.Flow

data class HabitsState(
    val habits: List<Habit> = emptyList(),
    val habitOrder: HabitOrder = HabitOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
