package com.harcamaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harcamaapp.model.Spending

class DetailViewModel:ViewModel(){

    val detailLiveData=MutableLiveData<Spending>()

    fun  getDataDetail(){
        val spending=Spending("Kira",1200,"TL","www.ss.com")
        detailLiveData.value=spending
    }


}