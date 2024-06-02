package com.example.uni_presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.uni_domain.GetUniversitiesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest

import kotlinx.coroutines.launch

@HiltViewModel
class UniversitiesListViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesListUseCase) :
    ViewModel() {

    private val _universitiesList = MutableStateFlow<UniversityListState>(UniversityListState.Empty)
    val universitiesList: StateFlow<UniversityListState> = _universitiesList

    val TAG = "UniListViewModel"
     fun getUniversities() {
         viewModelScope.launch {
             getUniversitiesUseCase.execute().collectLatest {
                 when (it) {
                     is Resource.Loading -> {
                         _universitiesList.value = UniversityListState.Loading(isLoading = true)
                     }

                     is Resource.Error -> {
                         Log.e(TAG, "getUniversities: Error")
                         _universitiesList.value = UniversityListState.Error(errorMsg = it.message)
                     }

                     is Resource.Success -> {
                         Log.d(TAG, "getUniversities: ${it.data}")
                         _universitiesList.value = UniversityListState.Success(list = it.data)
                     }
                 }

             }
         }



    }


}