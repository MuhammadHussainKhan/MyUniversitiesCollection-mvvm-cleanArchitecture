package com.example.uni_data.di

import com.example.common_db.dao.UniversityDAO
import com.example.uni_data.network.UniversityApiService
import com.example.uni_data.repository.UniversityRepository
import com.example.uni_data.repository.UniversityRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
object UniversityDataModule {

    @Provides
    fun provideUniversityApiService(retrofit: Retrofit): UniversityApiService {
        return retrofit.create(UniversityApiService::class.java)
    }

    @Provides
    fun provideUniversityRepository(uniApiService: UniversityApiService,uniDAO: UniversityDAO ):UniversityRepository{
        return UniversityRepositoryImp(uniApiService,uniDAO)
    }


}