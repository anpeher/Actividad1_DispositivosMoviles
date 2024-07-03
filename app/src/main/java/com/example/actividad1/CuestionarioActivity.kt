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
import java.util.regex.Pattern


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

    private fun insertImage(name: String, serie: String, imageUrl: String) {
        if (name.isNotEmpty() && serie.isNotEmpty() && imageUrl.isNotEmpty()) {
            if (isValidUrl(imageUrl)) {
                DibujosProvider.addDibujo(Dibujo(name, serie, imageUrl))
                Toast.makeText(this, "Dibujo añadido!", Toast.LENGTH_SHORT).show()
                val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("image_url", imageUrl)
                editor.apply()
                val i = Intent(this, ImageActivity::class.java)
                startActivity(i)

            } else {
                Toast.makeText(this, "Dirección URL no valida", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidUrl(url: String): Boolean {
        val urlPattern = Pattern.compile(
            "^(https?|ftp)://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w._-]*\\??[^#]*#?.*$",
            Pattern.CASE_INSENSITIVE
        )
        return urlPattern.matcher(url).matches()
    }
}