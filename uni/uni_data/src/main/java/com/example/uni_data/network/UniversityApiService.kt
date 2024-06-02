package com.example.uni_data.network

import com.example.uni_data.model.UniversityDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {

    //http://universities.hipolabs.com/search?country=United%20Arab%20Emirates

    @GET("search")
    suspend fun getUniversities(
        @Query("country") country:String,
    ): Response<List<UniversityDTO>>

}