package com.example.actividad1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad1.adapter.DibujosAdapter
import com.example.actividad1.services.DibujosProvider

class MainActivity : AppCompatActivity() {

    private lateinit var tvGoPrincipal: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        tvGoPrincipal = findViewById(R.id.tvPrincipal)
        tvGoPrincipal.setOnClickListener {
            goToLogin()
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDibujo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DibujosAdapter(DibujosProvider.dibujosList)
    }

    private fun goToLogin() {
        val i = Intent(this, PrincipalActivity::class.java)
        startActivity(i)
    }
}