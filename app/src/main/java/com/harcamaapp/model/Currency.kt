package com.harcamaapp.model

import com.google.gson.annotations.SerializedName

data class Currency(


    @SerializedName("USDEUR")
    val typeEuro:String?,
    @SerializedName("USDGBP")
    val typeSterlin:String?,
    @SerializedName("USDTRY")
    val typeTry:String?
)
