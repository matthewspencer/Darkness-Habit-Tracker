package com.android.darknesshabittracker.feature_habit.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.darknesshabittracker.feature_habit.domain.model.Habit

@Database(entities = [Habit::class], version = 1)
@TypeConverters(Converters::class)
abstract class HabitDatabase : RoomDatabase() {
    abstract fun habitDao(): RoomHabitDao

    companion object {
        const val DATABASE_NAME = "habits_db"
    }

}