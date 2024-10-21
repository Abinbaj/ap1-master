package com.example.ap1.ui.fragment

import ExercisesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController // Correct import
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap1.databinding.FragmentDashboardBinding
import com.example.ap1.viewmodels.DashboardFragment_ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardFragment_ViewModel by viewModels()
    private val args: DashboardFragmentArgs by navArgs() // Get the arguments passed from LoginFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        binding.recyclerViewDashboard.layoutManager = LinearLayoutManager(requireContext())

        // Observe the dashboard data using the keypass from arguments
        val keypass = args.keypass
        viewModel.getDashboardData(keypass).observe(viewLifecycleOwner) { dashboardData ->
            dashboardData?.let {
                // Setup the adapter and handle clicks
                val adapter = ExercisesAdapter(it.entities) { exercise ->
                    // Navigate to details fragment when an item is clicked
                    val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(
                        exerciseName = exercise.exerciseName,
                        description = exercise.description,
                        muscleGroup = exercise.muscleGroup,
                        caloriesBurned = exercise.caloriesBurnedPerHour,
                        difficulty = exercise.difficulty,
                        equipment = exercise.equipment
                    )
                    findNavController().navigate(action) // Correct navigation
                }
                binding.recyclerViewDashboard.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
