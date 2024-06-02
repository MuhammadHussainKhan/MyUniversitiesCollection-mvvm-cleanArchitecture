package com.example.detail_data.repository

import com.example.common_db.dao.UniversityDAO
import com.example.common_db.model.University
import javax.inject.Inject

class UniversityDetailRepositoryImp@Inject constructor (private val uniDAO: UniversityDAO): UniversityDetailRepository {

    override suspend fun getUniversityDetail(name: String): University? {
       return try {
         uniDAO.getUniversity(name)
       }catch (e: Exception){
           null
       }

    }
}