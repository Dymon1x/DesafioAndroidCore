package com.desafio.digitalhousefoods.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.R
import kotlinx.android.synthetic.main.item_restaurantes.view.*

class RestauranteAdapter(private val listaDeRestaurantes: ArrayList<Restaurante>, val listener: OnClickRestauranteListener): RecyclerView.Adapter<RestauranteAdapter.CardRestaurante>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardRestaurante {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurantes, parent, false)
        return CardRestaurante(itemView)
    }

    override fun onBindViewHolder(holder: CardRestaurante, position: Int) {
        val currentItem = listaDeRestaurantes[position]

        holder.imgRestaurante.setImageResource(currentItem.img)
        holder.nomeRestaurante.text = currentItem.nome
        holder.addressRestaurante.text = currentItem.address
        holder.horarioRestaurante.text = currentItem.horario

    }

    override fun getItemCount() = listaDeRestaurantes.size

    inner class CardRestaurante(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imgRestaurante: ImageView = itemView.img_restaurante
        val nomeRestaurante: TextView = itemView.tv_nome_restaurante
        val addressRestaurante: TextView = itemView.tv_address_restaurante
        val horarioRestaurante: TextView = itemView.tv_horario_restaurante

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.OnClickRestaurante(position)
        }
    }

    interface OnClickRestauranteListener{
        fun OnClickRestaurante(position: Int)
    }
}