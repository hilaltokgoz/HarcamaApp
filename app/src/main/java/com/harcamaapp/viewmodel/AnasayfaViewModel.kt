package com.harcamaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harcamaapp.model.Spending
//livedata canlı veriler üzerinde çalışmak
class AnasayfaViewModel:ViewModel() {

    val spending=MutableLiveData<List<Spending>>()
    val spendingError=MutableLiveData<Boolean>()//hata olursa true

   fun refreshData(){ //datalarımızı çekip refresh edicez
       val spend=Spending("Su Faturası",100,"Tl","www.ss.com")
       val spend2=Spending("Elektrik",150,"Tl","www.ss.com")
       val spend3=Spending("Alışveriş",1000,"Tl","www.ss.com")

       val spendList= arrayListOf<Spending>(spend,spend2,spend3)

       spending.value=spendList
       spendingError.value=false

   }

}