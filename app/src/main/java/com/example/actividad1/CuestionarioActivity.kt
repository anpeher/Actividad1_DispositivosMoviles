package com.example.actividad1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.actividad1.domain.Dibujo
import com.example.actividad1.services.DibujosProvider
import com.google.android.material.textfield.TextInputEditText


class CuestionarioActivity : AppCompatActivity() {

    private lateinit var eName: TextInputEditText
    private lateinit var eSerie: TextInputEditText
    private lateinit var eUrl: TextInputEditText
    private lateinit var buttonInsertar: Button
    private lateinit var tvGoPrincipal: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cuestionario)
        tvGoPrincipal = findViewById(R.id.tvPrincipal)
        tvGoPrincipal.setOnClickListener {
            goToPrincipal()
        }

        eName = findViewById(R.id.eName)
        eSerie = findViewById(R.id.eSerie)
        eUrl = findViewById(R.id.eURL)
        buttonInsertar = findViewById(R.id.buttonComentar)
        buttonInsertar.setOnClickListener {
            insertImage(eName.text.toString(), eSerie.text.toString(), eUrl.text.toString())
            eName.setText("")
            eSerie.setText("")
            eUrl.setText("")
        }
    }

    private fun goToPrincipal() {
        val i = Intent(this, MainMenuActivity::class.java)
        startActivity(i)
    }

    /**
     * Metodo que se ejecuta onSubmit del formulario
     *
     * @param name nombre del personaje a anyadir
     * @param serie serie del personaje a anyadir
     * @param imageUrl url de la imagen que se usa en el listado
     */
    private fun insertImage(name: String, serie: String, imageUrl: String) {
        // Definimos la variable dibujo que se inicializa posteriormente
        lateinit var dibujo: Dibujo

        // Validate input
        if (name.isEmpty() || serie.isEmpty() || imageUrl.isEmpty()) {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear dibujo. Si hay errores en la validacion mostrar mensaje y return
        try {
            dibujo = Dibujo(name, serie, imageUrl)
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, "Dirección URL no valida", Toast.LENGTH_SHORT).show()
            return
        }

        // Si todo ha ido bien anyadimos el dibujo
        DibujosProvider.addDibujo(dibujo)
        Toast.makeText(this, "Dibujo añadido!", Toast.LENGTH_SHORT).show()
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("image_url", imageUrl)
        editor.apply()
        val i = Intent(this, ImageActivity::class.java)
        startActivity(i)
    }
}