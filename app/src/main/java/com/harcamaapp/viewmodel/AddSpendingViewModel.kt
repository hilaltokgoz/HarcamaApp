package com.harcamaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harcamaapp.model.AddSpending


class AddSpendingViewModel:ViewModel(){
    val addSpendingLiveData= MutableLiveData<AddSpending>()
 fun setDataSpending(){
     val add= AddSpending("Su tarihte verildi","Dogalgaz","Fatura","Sterlin")
     addSpendingLiveData.value=add
 }

}