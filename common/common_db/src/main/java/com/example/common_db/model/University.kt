package com.example.common_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class University(
    @PrimaryKey(autoGenerate = false)
    val name: String ,
    val domains: List<String>,
    val webPages: List<String>,
    val alphaTwoCode: String,
    val stateProvince: String,
    val country: String
//    var webPages: ArrayList<String> = arrayListOf(),
)
