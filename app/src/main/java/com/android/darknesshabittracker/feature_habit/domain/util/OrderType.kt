package com.android.darknesshabittracker.feature_habit.domain.util

sealed class OrderType {
    data object Ascending: OrderType()
    data object Descending: OrderType()
}