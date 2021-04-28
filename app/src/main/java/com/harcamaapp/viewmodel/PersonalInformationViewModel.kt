package com.harcamaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harcamaapp.model.Personal


class PersonalInformationViewModel:ViewModel() {
    val personalLiveData= MutableLiveData<Personal>()
    fun setDataPersonal(){
        val personel=Personal("Hilal","Kadin")
        personalLiveData.value=personel
    }

}