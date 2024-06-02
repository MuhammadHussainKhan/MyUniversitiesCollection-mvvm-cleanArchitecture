package com.example.uni_domain.di

import com.example.uni_data.repository.UniversityRepository
import com.example.uni_domain.GetUniversitiesListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UniDomainModule {

    @Provides
    fun provideGetUniversitiesUseCase(universityRepository: UniversityRepository): GetUniversitiesListUseCase{
        return GetUniversitiesListUseCase(universityRepository)
    }
}