package com.harcamaapp.model

import androidx.lifecycle.MutableLiveData

data class AddSpending(
    val  explanation:String?,
    val spending:String?,
    val spendingType:String?,
    val currencyUnit:String
)
