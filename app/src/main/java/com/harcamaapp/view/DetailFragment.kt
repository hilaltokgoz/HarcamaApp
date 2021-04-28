package com.harcamaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.harcamaapp.R
import com.harcamaapp.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

//Harcama detaylarının olduğu fragment

class DetailFragment : Fragment() {
    private var spendingUuid=0//Uuid argümanımızın adıydı 0 atadık

     private  lateinit var viewModel:DetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel=ViewModelProviders.of(this).get(DetailViewModel::class.java) //viewmodel çağrılması
        viewModel.getDataDetail()


        arguments?.let {
            spendingUuid=DetailFragmentArgs.fromBundle(it).spendingUuid//uuid değişkenini diğer taraftan alabilmek için
        }
        observeLiveData()
    }

   private fun observeLiveData(){

       viewModel.detailLiveData.observe(viewLifecycleOwner, Observer {spending->
           spending?.let {
               tv_detail_name.text=spending.spendingType
               tv_detail_amount.text=spending.spendingAmount.toString() //tutar 50 yazıcak. tl,dolar kodda düzenlenecek.

           }
       })


   }


}