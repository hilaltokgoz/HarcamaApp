package com.harcamaapp.model

//Room:Yerel Sunucu
//Retrofit:Uzak Sunucu
//Room Database ,Retrofitin kullanılacağı alan
//Herhangi bir yerde Spending oluşturulabilir.(val test=Spendig())

data class Spending(   //DataClass: Veri tuttuğumuz sınıflar,database den veri çekerken
    val spendingType:String?,
    val spendingAmount:Int?,
    val currencyUnit:String?,
    val imageUrl:String?//ikonumuz url olarak gelirse
    )

