package com.android.darknesshabittracker.feature_habit.data.data_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomHabitDao {
    @Query("SELECT * FROM habit")
    fun getAll(): Flow<List<Habit>>

    @Insert
    fun add(habit: Habit)

    @Delete
    fun delete(habit: Habit)
}