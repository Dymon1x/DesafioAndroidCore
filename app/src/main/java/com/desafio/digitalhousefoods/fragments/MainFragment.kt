package com.desafio.digitalhousefoods.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.domain.Restaurante
import com.desafio.digitalhousefoods.domain.RestauranteAdapter
import java.util.ArrayList
import com.desafio.digitalhousefoods.R


class MainFragment : Fragment(), RestauranteAdapter.OnClickRestauranteListener {
    private val listaDeRestaurantes = getRestaurantes(3)
    private val adapter: RestauranteAdapter = RestauranteAdapter(listaDeRestaurantes, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val reView = view.findViewById<RecyclerView>(R.id.rvRestaurantes)
        reView.adapter = adapter
        reView.setHasFixedSize(true)
        
        return view
    }

    companion object{
        fun newInstance() = MainFragment()
    }


    fun getRestaurantes(size: Int): ArrayList<Restaurante> {
        val lista = ArrayList<Restaurante>()

        for (i in 0..size){
            when(i%4){
                0 -> lista.add(
                        Restaurante(
                                R.drawable.image1, "Tony Roma's",
                                "Avenida Lavandisca, 717 - Indianópolis, São Paulo",
                                "Fecha ás 22:00")
                )
                1 -> lista.add(
                        Restaurante
                        (R.drawable.image4,
                                "Aoyama - Moema",
                                "Alameda Dos Arapanés, 532 - Moema",
                                "Fecha ás 23:00")
                )
                2 -> lista.add(
                        Restaurante(
                                R.drawable.image5, "Outback - Moema",
                                "Av. Moaci, 187 - Moema, São Paulo",
                                "Fecha ás 01:00")
                )
                3 -> lista.add(
                        Restaurante(
                                R.drawable.image3,
                                "Sí Senõr!",
                                "Alameda juaperi, 626 - Moema",
                                "Fecha ás 02:40")
                )
            }
        }
        return lista
    }

    override fun OnClickRestaurante(position: Int) {
        val restaurante = listaDeRestaurantes.get(position)
        adapter.notifyItemChanged(position)

        val bundle = bundleOf("amount" to restaurante.img, "nome" to restaurante.nome)
        findNavController().navigate(R.id.action_mainFragment_to_restauranteFragment, bundle)

    }


}