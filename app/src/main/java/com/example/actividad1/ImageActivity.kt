package com.example.actividad1

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

// Definición de la clase ImageActivity que hereda de AppCompatActivity
class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_layout)
        // Busca el ImageView utilizando su ID
        val imageView = findViewById<ImageView>(R.id.imageView)
        // Obtiene las preferencias compartidas
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        // Obtiene la URL almacenada en las preferencias compartidas
        val imageUrl = sharedPreferences.getString("image_url", null)

        // Verifica si la URL de la imagen no es nula y usa la biblioteca Glide para cargar la imagen desde la URL en el ImageView
        if (imageUrl != null) {
            Glide.with(this)
                .load(imageUrl)
                .into(imageView)
        }
    }
}