package com.example.ap1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.ap1.R
import com.example.ap1.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    // SafeArgs to retrieve passed data
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind the exercise name and other details
        binding.detailsExerciseName.text = args.exerciseName
        binding.detailsDescription.text = args.description
        binding.detailsDifficulty.text = "Difficulty: ${args.difficulty}"
        binding.detailsEquipment.text = "Equipment: ${args.equipment}"
        binding.detailsCaloriesBurned.text = "Calories Burned: ${args.caloriesBurned} per hour"

        // Set the image for the exercise based on the name
        val imageResId = getImageResIdForExercise(args.exerciseName)
        binding.detailsExerciseImage.setImageResource(imageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // This method correlates the exercise name to the corresponding image in the drawable folder
    private fun getImageResIdForExercise(exerciseName: String): Int {
        return when (exerciseName.toLowerCase()) {

            "plank" -> R.drawable.plank2
            "squats" -> R.drawable.squat
            "deadlifts" -> R.drawable.deadlift2
            "push-ups" -> R.drawable.pushup
            "bench press" -> R.drawable.benchpress2
            "burpees" -> R.drawable.burpees2
            "mountain climbers" -> R.drawable.mountainclimbers2
            // Add more mappings here
            else -> R.drawable.deadlift // Default fallback image if no match is found
        }
    }
}
