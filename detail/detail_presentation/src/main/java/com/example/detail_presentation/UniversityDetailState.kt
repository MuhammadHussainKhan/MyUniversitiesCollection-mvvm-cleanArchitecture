package com.example.detail_presentation

import com.example.common_db.model.University

sealed class UniversityDetailState() {
    data class Loading(val isLoading: Boolean) : UniversityDetailState()
    data class Error(val errorMsg: String) : UniversityDetailState()
    data class Success(val university: University) : UniversityDetailState()
    object Empty : UniversityDetailState()

}
