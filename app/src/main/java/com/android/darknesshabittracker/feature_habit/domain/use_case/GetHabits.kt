package com.android.darknesshabittracker.feature_habit.domain.use_case

import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.repository.HabitRepository
import com.android.darknesshabittracker.feature_habit.domain.util.HabitOrder
import com.android.darknesshabittracker.feature_habit.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetHabits(
    private val repository: HabitRepository
) {
    operator fun invoke(
        habitOrder: HabitOrder = HabitOrder.Date(OrderType.Ascending)
    ): Flow<List<Habit>> {
        return repository.getHabits().map { habits ->
            when (habitOrder.orderType) {
                is OrderType.Ascending -> {
                    when (habitOrder) {
                        is HabitOrder.Date -> habits.sortedBy { it.dateAdded }
                        is HabitOrder.Title -> habits.sortedBy { it.title.lowercase() }
                    }
                }

                is OrderType.Descending -> {
                    when (habitOrder) {
                        is HabitOrder.Date -> {habits.sortedByDescending { it.dateAdded }}
                        is HabitOrder.Title -> {habits.sortedByDescending { it.title.lowercase() }}
                    }
                }
            }
        }
    }
}