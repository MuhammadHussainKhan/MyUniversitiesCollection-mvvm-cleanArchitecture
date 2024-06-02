package com.example.detail_domain

import com.example.common_db.model.University
import com.example.common_utils.Resource
import com.example.detail_data.repository.UniversityDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUniversityDetailUseCase @Inject constructor(private val uniRepository: UniversityDetailRepository ) {

    operator fun invoke(name: String): Flow<Resource<University>> = flow {
        emit(Resource.Loading())
        try {
           val uni= uniRepository.getUniversityDetail(name)
            if(uni!=null){
                emit(Resource.Success(data =uni!! ))
            }else{
                emit(Resource.Error(message ="No data Found..!"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }

}

