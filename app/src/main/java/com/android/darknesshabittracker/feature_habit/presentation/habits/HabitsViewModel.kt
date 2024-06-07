package com.android.darknesshabittracker.feature_habit.presentation.habits

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.darknesshabittracker.feature_habit.domain.model.Habit
import com.android.darknesshabittracker.feature_habit.domain.use_case.HabitUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitsViewModel @Inject constructor(
    val habitUseCases: HabitUseCases
) : ViewModel() {

    private val _state = mutableStateOf(HabitsState())
    var state = _state

    private var recentlyDeletedHabit: Habit? = null

    fun onEvent(event: HabitsEvent) {
        when (event) {
            is HabitsEvent.Order -> {

            }

            is HabitsEvent.DeleteHabit -> {
                viewModelScope.launch {
                    habitUseCases.deleteHabit(event.habit)
                    recentlyDeletedHabit = event.habit
                }
            }

            is HabitsEvent.RestoreHabit -> {

            }

            is HabitsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }
}