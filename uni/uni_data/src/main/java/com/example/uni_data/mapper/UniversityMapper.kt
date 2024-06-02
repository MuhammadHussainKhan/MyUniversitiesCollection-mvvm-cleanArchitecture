package com.example.uni_data.mapper

import com.example.common_db.model.University
import com.example.uni_data.model.UniversityDTO

fun UniversityDTO.toUniversityObject(): University {
    return University(
        name = this.name ?: "",
        domains = domains.toList()?: listOf(),
        webPages = webPages.toList()?: listOf(),
        alphaTwoCode= alphaTwoCode?: "",
        stateProvince= stateProvince?: "",
        country = country?:""
    )
}