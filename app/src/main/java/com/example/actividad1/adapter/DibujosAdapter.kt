package com.example.actividad1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad1.R
import com.example.actividad1.Dibujo


class DibujosAdapter(private val dibujoList:List<Dibujo>) : RecyclerView.Adapter<DibujosViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DibujosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DibujosViewHolder(layoutInflater.inflate(R.layout.item_dibujo, parent, false ))
    }

    override fun getItemCount(): Int {
        return dibujoList.size
    }

    override fun onBindViewHolder(holder: DibujosViewHolder, position: Int) {
        val item = dibujoList[position]
        holder.render(item)
    }
}