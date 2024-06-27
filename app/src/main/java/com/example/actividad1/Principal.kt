package com.example.actividad1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Principal : AppCompatActivity() {

    lateinit var tvGoCuestionario: TextView
    lateinit var tvGoDibujos: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)
        tvGoCuestionario = findViewById<TextView>(R.id.tvPrincipal)
        tvGoCuestionario.setOnClickListener{
            goToDibujos()
        }
        tvGoDibujos = findViewById<TextView>(R.id.tvCuestionario)
        tvGoDibujos.setOnClickListener{
            goToCuestionario()
        }

    }

    private fun goToCuestionario(){
        val i = Intent(this,Cuestionario::class.java)
        startActivity(i)
    }

    private fun goToDibujos(){
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)
    }
}