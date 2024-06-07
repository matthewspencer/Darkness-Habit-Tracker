package com.android.darknesshabittracker.feature_habit.domain.util

sealed class HabitOrder (
    val orderType: OrderType
) {
    class Title (orderType: OrderType): HabitOrder(orderType)
    class Date (orderType: OrderType): HabitOrder(orderType)
}