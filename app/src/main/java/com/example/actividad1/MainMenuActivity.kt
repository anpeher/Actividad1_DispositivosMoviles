package com.example.actividad1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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

    private fun goToCuestionario() {
        val i = Intent(this, CuestionarioActivity::class.java)
        startActivity(i)
    }

    private fun goToDibujos() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun goToImagenes() {
        val i = Intent(this, ImageActivity::class.java)
        startActivity(i)
    }
}