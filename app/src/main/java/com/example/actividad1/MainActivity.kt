package com.example.actividad1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad1.adapter.DibujosAdapter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDibujo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DibujosAdapter(DibujosProvider.dibujosList)

    }
}