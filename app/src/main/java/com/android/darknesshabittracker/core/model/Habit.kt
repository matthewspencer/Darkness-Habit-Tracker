package com.android.darknesshabittracker.core.model

import android.hardware.ConsumerIrManager.CarrierFrequencyRange

data class Habit(
    val id: Int,
    val name: String,
    val frequency: Int,
    val completedCount: Int,
    val xpReward: Int
)
