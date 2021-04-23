package com.harcamaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harcamaapp.R


class DetailFragment : Fragment() {
    private var spendingUuid=0//Uuid argümanımızın adıydı 0 atadık
//Harcama detaylarının olduğu fragment
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
/*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            spendingUuid=DetailFragmentArgs.fromBundle(it).spendingUuid//uuid değişkenini diğer taraftan alabilmek için
        }
    }*/

}