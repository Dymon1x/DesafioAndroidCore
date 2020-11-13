package com.desafio.digitalhousefoods.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.desafio.digitalhousefoods.R
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_register, container, false)
        view.btn_register_account.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_mainActivity)
        }

        return view
    }

    companion object {
        fun newInstance() = RegisterFragment()
    }
}