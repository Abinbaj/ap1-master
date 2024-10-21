package com.example.ap1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsFragment_ViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Retrieve arguments passed via SafeArgs
    private val exerciseName: String = savedStateHandle["exerciseName"] ?: ""
    private val description: String = savedStateHandle["description"] ?: ""
    private val muscleGroup: String = savedStateHandle["muscleGroup"] ?: ""
    private val caloriesBurned: Int = savedStateHandle["caloriesBurned"] ?: 0
    private val difficulty: String = savedStateHandle["difficulty"] ?: ""
    private val equipment: String = savedStateHandle["equipment"] ?: ""

    // LiveData to expose the details to the fragment
    private val _exerciseDetails = MutableLiveData<ExerciseDetails>()
    val exerciseDetails: LiveData<ExerciseDetails> get() = _exerciseDetails

    init {
        // Initialize the LiveData with the data from SafeArgs
        _exerciseDetails.value = ExerciseDetails(
            exerciseName = exerciseName,
            description = description,
            muscleGroup = muscleGroup,
            caloriesBurned = caloriesBurned,
            difficulty = difficulty,
            equipment = equipment
        )
    }

    // Data class to hold the exercise details
    data class ExerciseDetails(
        val exerciseName: String,
        val description: String,
        val muscleGroup: String,
        val caloriesBurned: Int,
        val difficulty: String,
        val equipment: String
    )
}
