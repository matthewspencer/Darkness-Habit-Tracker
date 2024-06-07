package com.android.darknesshabittracker.feature_habit.data.repository

import com.android.darknesshabittracker.feature_habit.data.data_source.local.RoomHabitDao
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow

class HabitRepositoryImpl(
    private val dao: RoomHabitDao
) : HabitRepository {
    override fun getHabits(): Flow<List<Habit>> {
        return dao.getAll()
    }

    override fun createHabit(habit: Habit) {
        dao.add(habit)
    }

    override suspend fun deleteHabit(habit: Habit) {
        dao.delete(habit)
    }
}