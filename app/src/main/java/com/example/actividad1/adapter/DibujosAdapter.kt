package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Dibujo
import com.example.recyclerview.R

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