package com.harcamaapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.harcamaapp.R
import com.harcamaapp.model.Spending
import com.harcamaapp.view.AnasayfaFragmentDirections
import kotlinx.android.synthetic.main.item_spending_list.view.*

///dışardan arraylist isticez.RecylerviewList için adapter yazdık.
class SpendingAdapter (val spendingList:ArrayList<Spending>):RecyclerView.Adapter<SpendingAdapter.SpendingViewHolder>() {

    class SpendingViewHolder(var view: View) :RecyclerView.ViewHolder( view) { //viewHolder oluşumu

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpendingViewHolder { //layout ile adapter birbirine bağlanır.
      val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_spending_list,parent,false)  //recylerview itemını bağladık.
        return SpendingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpendingViewHolder, position: Int) {  //kullandığımız layoutdaki itemdaki bölgelere ulaşabiliriz.
      holder.view.tv_spendingName.text=spendingList[position].spendingType //harcama adını gösterdik.
      holder.view.tv_spendingAmound.text=spendingList[position].currencyUnit //tutar gösterildi.

        //imageView glaide ile gösterilecek.

        //view e tıklanınca ne olacak
     holder.view.setOnClickListener {
      val action=AnasayfaFragmentDirections.actionAnasayfaFragment2ToDetailFragment()
         Navigation.findNavController(it).navigate(action)
     }

    }

    override fun getItemCount(): Int {  //Kaç tane item olucak
       return spendingList.size //liste boyutu kadar
    }

    fun updateSpendingList(newSpendingList:List<Spending>){ //anasayfa fragment ekranındaki swiperefresh için yazılan adapter
        spendingList.clear()
        spendingList.addAll(newSpendingList)
        notifyDataSetChanged()//adapterı yenileme metodu

    }
}