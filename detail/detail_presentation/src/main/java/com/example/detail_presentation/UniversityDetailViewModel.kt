package com.example.detail_presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.detail_domain.GetUniversityDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityDetailViewModel @Inject constructor(private val getUniversityDetailUseCase: GetUniversityDetailUseCase): ViewModel() {

    private val _universityDetail = MutableStateFlow<UniversityDetailState>(UniversityDetailState.Empty)
    val universityDetail: StateFlow<UniversityDetailState> = _universityDetail
    val TAG = "Unidetail"

    fun getUniversityDetail(name: String){
        viewModelScope.launch {
            getUniversityDetailUseCase(name).collectLatest {
                when (it) {
                    is Resource.Loading -> {
                        _universityDetail.value = UniversityDetailState.Loading(isLoading = true)
                    }

                    is Resource.Error -> {

                        Log.e(TAG, "getUniversities: Error")
                        _universityDetail.value = UniversityDetailState.Error(errorMsg = it.message)
                    }

                    is Resource.Success -> {
                        Log.d(TAG, "getUniversities: ${it.data}")
                        _universityDetail.value = UniversityDetailState.Success(university = it.data!!)
                    }
                }

            }
        }
    }
}