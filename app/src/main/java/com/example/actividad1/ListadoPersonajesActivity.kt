package com.example.actividad1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actividad1.adapter.DibujosAdapter
import com.example.actividad1.services.DibujosProvider

/**
 * En esta página se crea el RecyclerView
 */
class ListadoPersonajesActivity : AppCompatActivity() {

    private lateinit var tvGoPrincipal: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listado_personajes)
        initRecyclerView()
        tvGoPrincipal = findViewById(R.id.tvPrincipal)
        tvGoPrincipal.setOnClickListener {
            goToMainMenu()
        }
    }


    /**
     * Inicializa el RecyclerView para mostrar la lista de dibujos.
     *
     * Este método configura el RecyclerView asignándole un gestor de diseño y un adaptador.
     * y un adaptador. El gestor de diseño determina cómo se organizan los elementos.
     */
    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDibujo)
        //crea una lista vertical de elementos
        recyclerView.layoutManager = LinearLayoutManager(this)
        //el adapatador nos provee los datos para insertarlos en el RecyclerView
        recyclerView.adapter = DibujosAdapter(DibujosProvider.dibujosList)
    }

    /**
     * Carga los elementos cada vez que la actividad se vuelve visible, para que actualice el initCrecyclerView()
     * con los nuevos datos de DibujoProvider
     */
    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }

    /**
     * navegación para ir al menu principal
     */
    private fun goToMainMenu() {
        val i = Intent(this, MainMenuActivity::class.java)
        startActivity(i)
    }
}