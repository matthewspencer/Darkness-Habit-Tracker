package com.android.darknesshabittracker.feature_habit.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @PrimaryKey val id: Int,
    val title: String,
    val notes: String,
    val positive: Boolean,
    val negative: Boolean,
    val difficulty: HabitDifficulty,
    val dateAdded: Long,
    val tag: HabitTag
)

sealed class HabitDifficulty {
    data object Trivial : HabitDifficulty()
    data object Easy : HabitDifficulty()
    data object Medium : HabitDifficulty()
    data object Hard : HabitDifficulty()
}

data class HabitTag(
    val title: String,
    val isSelected: Boolean
)
