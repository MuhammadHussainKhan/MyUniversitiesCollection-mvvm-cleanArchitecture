package com.example.uni_data.repository

import com.example.common_db.model.University
import com.example.uni_data.model.UniversityDTO

interface UniversityRepository {

    suspend fun getUniversitiesList():List<University>

}