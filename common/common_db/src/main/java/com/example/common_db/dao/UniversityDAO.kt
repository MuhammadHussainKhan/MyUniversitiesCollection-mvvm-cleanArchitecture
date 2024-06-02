package com.example.common_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.common_db.model.University

@Dao
interface UniversityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list:List<University>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list:University)


    @Query("SELECT * FROM University")
    suspend fun getAllUniversities():List<University>

    @Query("SELECT * FROM University where name = :name")
    suspend fun getUniversity(name: String):University?


}