package com.example.detail_domain.di

import com.example.detail_data.repository.UniversityDetailRepository
import com.example.detail_domain.GetUniversityDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UniversityDetailDomainModule {

    @Provides
    fun getUniversityDetailUseCase(universityDetailRepository: UniversityDetailRepository): GetUniversityDetailUseCase{
        return GetUniversityDetailUseCase(universityDetailRepository)
    }
}