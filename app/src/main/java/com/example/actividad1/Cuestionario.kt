package com.example.actividad1

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Cuestionario : AppCompatActivity() {

    lateinit var eName: TextInputEditText;
    lateinit var buttonPublicar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cuestionario)
        eName = findViewById(R.id.eName)
        buttonPublicar = findViewById(R.id.buttonComentar)
        buttonPublicar.setOnClickListener({
            Log.i(TAG, eName.text.toString())
        })

    }
}