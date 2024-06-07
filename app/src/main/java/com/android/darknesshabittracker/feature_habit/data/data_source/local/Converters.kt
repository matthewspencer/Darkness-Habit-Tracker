package com.android.darknesshabittracker.feature_habit.data.data_source.local

import androidx.room.TypeConverter
import com.android.darknesshabittracker.feature_habit.domain.model.HabitDifficulty
import com.android.darknesshabittracker.feature_habit.domain.model.HabitTag

class Converters {

    @TypeConverter
    fun fromDifficultyToString(difficulty: HabitDifficulty): String {
        return difficulty.toString().lowercase()
    }

    @TypeConverter
    fun fromStringToDifficulty(value: String): HabitDifficulty {
        return when (value.lowercase()) {
            "trivial" -> HabitDifficulty.Trivial
            "easy" -> HabitDifficulty.Easy
            "medium" -> HabitDifficulty.Medium
            else -> HabitDifficulty.Hard
        }
    }

    @TypeConverter
    fun fromTagToString(tag: HabitTag): String {
        return "${tag.title};${tag.isSelected}"
    }

    @TypeConverter
    fun fromStringToTag(value: String): HabitTag {
        val parts = value.split(";")
        val title = parts[0]
        val isSelected = parts[1].toBoolean()
        return HabitTag(title, isSelected)
    }
}