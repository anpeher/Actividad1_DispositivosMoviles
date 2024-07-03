package com.example.actividad1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad1.R
import com.example.actividad1.domain.Dibujo

/**
 * Clase que que define el adapter de los dibujos
 *
 * @param dibujoList lista de dibujos
 */
class DibujosAdapter(private val dibujoList: List<Dibujo>) : RecyclerView.Adapter<DibujosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DibujosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DibujosViewHolder(layoutInflater.inflate(R.layout.item_dibujo, parent, false))
    }

    /**
     * Metodo que retorna el numero de elementos a renderizar
     */
    override fun getItemCount(): Int {
        return dibujoList.size
    }

    /**
     * Metodo que renderiza el dibujo de la lista
     *
     * @param holder ViewHolder que contiene la logica para renderizar el dibujo
     * @param position posicion del elemento a renderizar
     */
    override fun onBindViewHolder(holder: DibujosViewHolder, position: Int) {
        val item = dibujoList[position]
        holder.render(item)
    }
}