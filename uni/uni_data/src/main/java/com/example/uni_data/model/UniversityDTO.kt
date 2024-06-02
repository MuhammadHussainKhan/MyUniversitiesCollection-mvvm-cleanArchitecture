package com.example.uni_data.model

import com.google.gson.annotations.SerializedName

data class UniversityDTO(

    @SerializedName("domains")
    var domains: ArrayList<String> = arrayListOf(),

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("web_pages")
    var webPages: ArrayList<String> = arrayListOf(),

    @SerializedName("alpha_two_code")
    var alphaTwoCode: String? = null,

    @SerializedName("state-province")
    var stateProvince: String? = null,

    @SerializedName("country")
    var country: String? = null

)
