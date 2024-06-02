package com.example.detail_data.repository

import com.example.common_db.model.University

interface UniversityDetailRepository {
    suspend fun getUniversityDetail(name: String): University?
}