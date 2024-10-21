package com.example.ap1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.ap1.data.ApiRepository
import com.example.ap1.data.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DashboardFragment_ViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun getDashboardData(keypass: String): LiveData<DashboardResponse?> = liveData(Dispatchers.IO) {
        try {
            // Fetch data from the repository
            val response = apiRepository.getDashboardData(keypass)
            emit(response)
        } catch (e: Exception) {
            emit(null)
        }
    }
}
