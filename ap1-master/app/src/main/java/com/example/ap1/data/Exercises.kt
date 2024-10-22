package com.example.ap1.data

data class Exercises(
    val caloriesBurnedPerHour: Int,
    val description: String,
    val difficulty: String,
    val equipment: String,
    val exerciseName: String,
    val muscleGroup: String,
)
data class DashboardResponse(
    val entities: List<Exercises>,
    val entityTotal: Int
)