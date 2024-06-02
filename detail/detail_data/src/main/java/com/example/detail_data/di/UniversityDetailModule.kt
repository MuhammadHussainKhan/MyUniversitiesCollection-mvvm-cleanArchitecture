package com.example.detail_data.di

import com.example.common_db.dao.UniversityDAO
import com.example.detail_data.repository.UniversityDetailRepository
import com.example.detail_data.repository.UniversityDetailRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UniversityDetailModule {

    @Provides
    fun  provideUniversityDetailRepository(uniDAO: UniversityDAO): UniversityDetailRepository{
        return UniversityDetailRepositoryImp(uniDAO)
    }
}