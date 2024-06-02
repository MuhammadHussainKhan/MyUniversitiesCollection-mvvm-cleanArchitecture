package com.example.uni_presentation

import com.example.common_db.model.University

sealed class UniversityListState() {
    data class Loading(val isLoading: Boolean) : UniversityListState()
    data class Error(val errorMsg: String) : UniversityListState()
    data class Success(val list: List<University>?) : UniversityListState()
    object Empty : UniversityListState()

}
