package com.example.actividad1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class Cuestionario : AppCompatActivity() {

    private lateinit var eName: TextInputEditText
    private lateinit var eSerie: TextInputEditText
    private lateinit var eUrl: TextInputEditText
    private lateinit var buttonInsertar : Button
    private lateinit var tvGoPrincipal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cuestionario)
        tvGoPrincipal = findViewById(R.id.tvPrincipal)
        tvGoPrincipal.setOnClickListener{
            goToPrincipal()
        }

        eName = findViewById(R.id.eName)
        eSerie = findViewById(R.id.eSerie)
        eUrl = findViewById(R.id.eURL)
        buttonInsertar = findViewById(R.id.buttonComentar)
        buttonInsertar.setOnClickListener{

            val name = eName.text.toString()
            val serie = eSerie.text.toString()
            val imageUrl = eUrl.text.toString()

            if (name.isNotEmpty() && serie.isNotEmpty() && imageUrl.isNotEmpty()) {

                //DibujosProvider.addDibujo(Dibujo(name, serie, imageUrl))
                Toast.makeText(this, "Dibujo añadido!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun goToPrincipal(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}