package com.desafio.digitalhousefoods.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.desafio.digitalhousefoods.R
import kotlinx.android.synthetic.main.fragment_detail.view.*


class DetailFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        view.btn_voltar_prato.setOnClickListener {
           findNavController().navigate(R.id.action_detailFragment_to_restauranteFragment)
        }



        return view
    }


}