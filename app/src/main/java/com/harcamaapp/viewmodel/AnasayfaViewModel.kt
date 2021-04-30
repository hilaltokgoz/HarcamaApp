package com.harcamaapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harcamaapp.model.CurrencyConverter
import com.harcamaapp.model.Spending
import com.harcamaapp.service.SpendingAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

//livedata canlı veriler üzerinde çalışmak
class AnasayfaViewModel : ViewModel() {

    private val spendingApiService = SpendingAPIService()
    private val disposable =
        CompositeDisposable()//call yaptıkça bunun içine atıyoruz.En son disposanle ı atıp hafızayı boşaltıyor.


    val spending = MutableLiveData<List<Spending>>()
    val spendingError = MutableLiveData<Boolean>()//hata olursa true

    fun refreshData() { //datalarımızı çekip refresh edicez
        val spending1 = Spending("Alisveris", 500, "TL", "www.ss.com")
        val spending2 = Spending("Kira", 1000, "Dolar", "www.ss.com")
        val spending3 = Spending("Elektrik", 200, "TL", "www.ss.com")

        val spendingList = arrayListOf<Spending>(spending1, spending2, spending3)

        spending.value = spendingList


        getDataFromAPI()
    }
    fun toUsd(){
        //TODO: parabirimlerini çevir.
        val deger:Float?
        



    }
    fun toTry(){
        getDataFromAPI()
    }





    fun getDataFromAPI() {

        disposable.addAll(
            spendingApiService.getData()
                .subscribeOn(Schedulers.newThread())//asenkronize şekilde yapıcaz.
                .observeOn(AndroidSchedulers.mainThread())//nerde gözlemlicez.
                .subscribeWith(object : DisposableSingleObserver<CurrencyConverter>() {
                    override fun onSuccess(t: CurrencyConverter) {
                        println(t.currency.typeTry)

                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace() //hata mesajını kendimiz görebiliyoruz.

                        println("test1:${e.message}")
                    }

                })
        )
    }

}
