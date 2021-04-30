package com.harcamaapp.service

import com.harcamaapp.model.Currency
import com.harcamaapp.model.CurrencyConverter
import com.harcamaapp.model.Spending
import io.reactivex.Single
import retrofit2.http.GET


interface SpendingAPI {
    //Retrofitte yapılacak işlemleri yazarız.
    // GET: Veri çekerken
    //Post: veri Değiştirirken
    //adres: http://apilayer.net/api/live?access_key=b3bb4d210ce2ff590d0552f2ac549e90&currencies=EUR,GBP,TRY&source=USD&format=1.json
    //Retrofit , URL i ikiye ayıırır.
    //1.BASE_URL->.com/ a kadar olan kısım
    //2.Extention URL-> kalan kısım

    @GET("api/live?access_key=b3bb4d210ce2ff590d0552f2ac549e90&currencies=EUR,GBP,TRY&source=USD&format=1.json") //ext kısmı yazılır.

    //Retrofitle yapılsaydı ,CALL,RXJava ile->Single
    fun getSpending():Single<CurrencyConverter>




}