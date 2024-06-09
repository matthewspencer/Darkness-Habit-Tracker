package com.android.darknesshabittracker.features_character.domain

data class Charachter(
    val name: String,
    val currHp: Int,
    val maxHp: Int,
    val lvl: Int,
    val currXp: Int,
    val lvlUpXp: Int
)
