package com.desafio.digitalhousefoods.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.R
import com.desafio.digitalhousefoods.domain.Pratos
import com.desafio.digitalhousefoods.domain.PratosAdapter
import kotlinx.android.synthetic.main.fragment_restaurante.view.*
import java.util.ArrayList


class RestauranteFragment : Fragment(), PratosAdapter.OnClickPratosListener {
    private val listaPratos = getPratos(9)
    private val adapter: PratosAdapter = PratosAdapter(listaPratos, this)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_restaurante, container, false)
//        arguments?.getInt("amount")?.let {
//            view.imgPrincipal.setImageResource(it)
//        }
//
//        arguments?.getString("nome")?.let {
//            view.tv_nome_restaurante_card.text = it
//        }

        val reView = view.findViewById<RecyclerView>(R.id.rvPratos)
        reView.adapter = adapter
        reView.layoutManager = GridLayoutManager(context, 2)
        reView.setHasFixedSize(true)

        view.btn_voltar.setOnClickListener {
            findNavController().navigate(R.id.action_restauranteFragment_to_mainFragment)
        }
        return view
    }

    companion object {
        fun newInstance() = RestauranteFragment()
    }

    fun getPratos(size: Int): ArrayList<Pratos> {
        val lista = ArrayList<Pratos>()

        for (i in 0..size) {
            when (i % 2) {
                0 -> lista.add(
                        Pratos(
                                "Salada com molho gengibre",
                                R.drawable.image4)
                )
                1 -> lista.add(
                        Pratos(
                                "Salada com molho gengibre",
                                R.drawable.image4)
                )
            }
        }


        return lista
    }

    override fun OnClickPratos(position: Int) {
        val pratos = listaPratos.get(position)
        adapter.notifyItemChanged(position)


        findNavController().navigate(R.id.action_restauranteFragment_to_detailFragment)
    }

}