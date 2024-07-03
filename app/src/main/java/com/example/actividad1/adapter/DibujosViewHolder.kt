package com.example.actividad1.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.actividad1.R
import com.example.actividad1.domain.Dibujo


/**
 * Clase que renderiza la view de un Dibujo
 *
 * @param view instancia del objeto que renderiza los datos
 */
class DibujosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val dibujoPhoto = view.findViewById<ImageView>(R.id.dibujoImage)
    val dibujoName = view.findViewById<TextView>(R.id.dibujoName)
    val dibujoSerie = view.findViewById<TextView>(R.id.dibujoSerie)

    /**
     * Metodo que renderiza los datos de un dibujo en la view
     *
     * @param dibujoModel instancia de Dibujo con los datos que se renderizan en la view
     */
    fun render(dibujoModel: Dibujo) {
        dibujoName.text = dibujoModel.name
        dibujoSerie.text = dibujoModel.serie
        Glide.with(dibujoPhoto.context).load(dibujoModel.photo).into(dibujoPhoto)
    }
}