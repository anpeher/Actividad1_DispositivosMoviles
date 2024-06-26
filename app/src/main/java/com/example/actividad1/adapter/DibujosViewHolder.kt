package com.example.recyclerview.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.actividad1.R
import com.example.recyclerview.Dibujo


class DibujosViewHolder(view:View):RecyclerView.ViewHolder (view)  {

    val dibujoPhoto = view.findViewById<ImageView>(R.id.dibujoImage)
    val dibujoName = view.findViewById<TextView>(R.id.dibujoName)
    val dibujoSerie = view.findViewById<TextView>(R.id.dibujoSerie)

    fun render(dibujoModel: Dibujo){
        dibujoName.text = dibujoModel.name
        dibujoSerie.text = dibujoModel.serie
        Glide.with(dibujoPhoto.context).load(dibujoModel.photo).into(dibujoPhoto)

    }
}