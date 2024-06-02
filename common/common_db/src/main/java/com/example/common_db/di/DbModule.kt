package com.example.common_db.di

import android.content.Context
import androidx.room.Room
import com.example.common_db.AppDatabase
import com.example.common_db.dao.UniversityDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
      fun provideUniDatabase(@ApplicationContext context: Context): AppDatabase =
         Room.databaseBuilder(context, AppDatabase::class.java, "uni_app_db2")
        .fallbackToDestructiveMigration().build()
// @Provides
//    @Singleton
//     suspend fun provideUniDatabase(@ApplicationContext context: Context):  AppDatabase {
//    GlobalScope.launch(Dispatchers.IO) {
//        val db = AppDatabase.getInstance(context)
//    }
//}

//    @Provides
//    @Singleton
//    fun provideUniDatabase(@ApplicationContext context: Context): AppDatabase {
//        return runBlocking(Dispatchers.IO) {
//            AppDatabase.getInstance(context)
//        }
//    }

//    @Provides
//    fun provideDatabaseDispatcher(): CoroutineDispatcher {
//        return Dispatchers.IO
//    }

    @Provides
    fun provideUniDAO(appDatabase: AppDatabase): UniversityDAO {
        return appDatabase.getUniversityDao()
    }
}