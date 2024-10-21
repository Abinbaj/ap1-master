package com.example.ap1.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ap1.databinding.FragmentDetailsBinding
import com.example.ap1.viewmodels.DetailsFragment_ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val detailsViewModel: DetailsFragment_ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the exercise details from the ViewModel and update the UI
        detailsViewModel.exerciseDetails.observe(viewLifecycleOwner) { details ->
            binding.tvExerciseName.text = details.exerciseName
            binding.tvDescription.text = details.description
            binding.tvMuscleGroup.text = details.muscleGroup
            binding.tvCaloriesBurned.text = details.caloriesBurned.toString()
            binding.tvDifficulty.text = details.difficulty
            binding.tvEquipment.text = details.equipment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
