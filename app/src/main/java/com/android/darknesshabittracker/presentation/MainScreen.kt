package com.android.darknesshabittracker.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.model.HabitDifficulty
import com.android.darknesshabittracker.feature_habit.domain.model.HabitTag

@Composable
fun HabitList(habits: List<Habit>) {
    LazyColumn {
        items(habits) {
            HabitItem(it)
        }
    }
}

@Composable
fun HabitItem(habit: Habit) {
    Card(modifier = Modifier.padding(8.dp)) {
        Text(text = habit.title)
    }
}

@Preview
@Composable
fun HabitListPreview() {
    HabitList(listOf(Habit(123,"Wow", "",true, false, HabitDifficulty.Medium, 123, HabitTag("", false))))
}

