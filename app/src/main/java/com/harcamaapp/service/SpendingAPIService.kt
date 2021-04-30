package com.harcamaapp.service

import com.harcamaapp.model.CurrencyConverter
import com.harcamaapp.model.Spending
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SpendingAPIService {
     //URL=
     // Base->  http://apilayer.net/
     //Ext->    api/live?access_key=b3bb4d210ce2ff590d0552f2ac549e90&currencies=EUR,GBP,TRY&source=USD&format=1.json

    private val BASE_URL="http://apilayer.net/"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL) //base url verildi
        .addConverterFactory(GsonConverterFactory.create()) //gson kullanılacağı belirtildi.
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //rxJava kullanacağını belirttin.
        .build()
        .create(SpendingAPI::class.java) //API ile bağladık.


    fun getData():Single<CurrencyConverter>{
        return api.getSpending()
    }



}
