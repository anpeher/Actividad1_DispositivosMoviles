package com.example.actividad1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Clase que contiene la actividad MainMenu. La actividad principal de la aplicacion.
 */
class MainMenuActivity : AppCompatActivity() {

    lateinit var tvGoCuestionario: TextView
    lateinit var tvGoDibujos: TextView
    lateinit var tvGoImagenes: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
        tvGoCuestionario = findViewById<TextView>(R.id.tvPrincipal)
        tvGoCuestionario.setOnClickListener {
            goToDibujos()
        }
        tvGoDibujos = findViewById<TextView>(R.id.tvCuestionario)
        tvGoDibujos.setOnClickListener {
            goToCuestionario()
        }
        tvGoImagenes = findViewById<TextView>(R.id.tvImagenes)
        tvGoImagenes.setOnClickListener {
            goToImagenes()
        }
    }

    /**
     * Metodo que cambia la actividad a la pagina del cuestionario
     */
    private fun goToCuestionario() {
        val i = Intent(this, CuestionarioActivity::class.java)
        startActivity(i)
    }

    /**
     * Metodo que cambia la actividad a la pagina del listado de personajes
     */
    private fun goToDibujos() {
        val i = Intent(this, ListadoPersonajesActivity::class.java)
        startActivity(i)
    }

    /**
     * Metodo que cambia la actividad a la pagina que muestra la imagen recientemente anyadida
     */
    private fun goToImagenes() {
        val i = Intent(this, ImageActivity::class.java)
        startActivity(i)
    }
}