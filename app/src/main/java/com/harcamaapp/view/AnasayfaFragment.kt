package com.harcamaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
//import com.harcamaapp.AnasayfaFragmentDirections
import com.harcamaapp.R
import com.harcamaapp.adapter.SpendingAdapter
import com.harcamaapp.viewmodel.AnasayfaViewModel
import kotlinx.android.synthetic.main.fragment_anasayfa.*


class AnasayfaFragment : Fragment() {

    private lateinit var viewModel:AnasayfaViewModel
    private val spendinAdapter=SpendingAdapter(arrayListOf())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anasayfa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //fragment ile viEwModel bağlandı.
        viewModel=ViewModelProviders.of(this).get(AnasayfaViewModel::class.java)  //hangi fragmenttayız hangi viewModel sınıfıyla çalışmak istiyoruz.
        viewModel.refreshData()

         rv_spendingList.layoutManager=LinearLayoutManager(context) //LinearLayoutManager row ları alt alta göstermemeise olanak sağlar.
         rv_spendingList.adapter=spendinAdapter

      tv_personalName.setOnClickListener {
           val action= AnasayfaFragmentDirections.actionAnasayfaFragment2ToPersonalInformationFragment()
            Navigation.findNavController(it).navigate(action)//geçiş işlemi
        }



        observeLiveData()//fonk çağrıldı.
    }
     //Oluşturulan LiveData ları kullanıdk.
    private fun observeLiveData(){
          viewModel.spending.observe(viewLifecycleOwner, Observer { spending-> //spending boş mu dolu mu kontrolü için
              spending?.let {
                rv_spendingList.visibility=View.VISIBLE //RecyclerView görünür hale geldi
                 spendinAdapter.updateSpendingList((spending))

              }
          })
      }




}