package com.example.actividad1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class Cuestionario : AppCompatActivity() {

    lateinit var eName: TextInputEditText
    lateinit var buttonPublicar : Button
    lateinit var tvGoPrincipal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cuestionario)
        tvGoPrincipal = findViewById<TextView>(R.id.tvPrincipal)
        tvGoPrincipal.setOnClickListener{
            goToLogin()
        }


    }

    private fun goToLogin(){
        val i = Intent(this,Principal::class.java)
        startActivity(i)
    }
}