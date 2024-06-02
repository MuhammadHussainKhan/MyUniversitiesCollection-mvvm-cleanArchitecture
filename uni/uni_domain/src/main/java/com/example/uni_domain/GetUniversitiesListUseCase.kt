package com.example.uni_domain

import com.example.common_db.model.University
import com.example.common_utils.Resource
import com.example.uni_data.repository.UniversityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUniversitiesListUseCase @Inject constructor(private val uniRepository: UniversityRepository) {

     fun execute(): Flow<Resource<List<University>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = uniRepository.getUniversitiesList()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}

