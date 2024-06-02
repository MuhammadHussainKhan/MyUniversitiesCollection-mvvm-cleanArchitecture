package com.example.uni_data.repository

import android.util.Log
import com.example.common_db.dao.UniversityDAO
import com.example.common_db.model.University
import com.example.common_utils.Constants
import com.example.uni_data.mapper.toUniversityObject
import com.example.uni_data.network.UniversityApiService
import javax.inject.Inject

class UniversityRepositoryImp @Inject constructor (private val uniApiService: UniversityApiService, private val uniDAO: UniversityDAO): UniversityRepository {

    override suspend fun getUniversitiesList(): List<University> {
        return try {
            val temp =
                uniApiService.getUniversities(country = Constants.COUNTRY).body()?.map { it.toUniversityObject() }
            uniDAO.insertList(temp?: listOf())
            uniDAO.getAllUniversities()
        } catch (e: Exception) {
            e.stackTrace
            Log.e("uniRepoImp", "getUniversitiesList: ${e.message?:""}", )
            uniDAO.getAllUniversities()
        }
    }
}

