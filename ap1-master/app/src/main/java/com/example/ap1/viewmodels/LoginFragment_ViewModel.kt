package com.example.ap1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.ap1.data.ApiRepository
import com.example.ap1.data.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class LoginFragment_ViewModel @Inject constructor(private val apiRepository: ApiRepository) : ViewModel() {

    fun login(username: String, password: String): LiveData<Result<LoginResponse>> = liveData(Dispatchers.IO) {
        try {
            val response = apiRepository.login(username, password)
            emit(Result.success(response))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
