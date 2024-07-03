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

/**
 * Pantalla donde se mostrará un cuestionario para que el usuario lo rellene.
 * Su principal funcionalidad es obtener la información del usuario e insertárla en el archivo DibujoProvider
 * para mostrarla en el recyclerView. Posee otras funcionalidades secundarias como navegación al MainMenu o
 * modificar el componente de ImageActivity con la imagen que se ñade
 */
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
        /**
         * Cuando el usuario pulsa el boton se activa la función e independientemente de si mete los datos correctamente o no
         * se borran
         */
        buttonInsertar.setOnClickListener {
            insertImage(eName.text.toString(), eSerie.text.toString(), eUrl.text.toString())
            eName.setText("")
            eSerie.setText("")
            eUrl.setText("")
        }
    }

    /**
     * Navegación para ir a la pantalla main menu
     */
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
     * Si se añade los campos correctamente añade el dibujo a la lista de dibujos para mostrar en el recyclerView
     * y se modifica el componente ImageView poniendo la nueva imagen como la nueva incluso cuando se reinicia
     * la aplicación terminando en la pantalla ImageView para verla. En caso de que no escribas en un campo
     * o metas un URL incorrecto te saldrá una notificación.
     */
    private fun insertImage(name: String, serie: String, imageUrl: String) {
        // Definimos la variable dibujo que se inicializa posteriormente
        lateinit var dibujo: Dibujo

        // Validamos si no hay ningún textInput vacío
        if (name.isEmpty() || serie.isEmpty() || imageUrl.isEmpty()) {
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Crea el dibujo. Si hay errores en la validacion mostrar mensaje y return
        try {
            dibujo = Dibujo(name, serie, imageUrl)
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, "Dirección URL no valida", Toast.LENGTH_SHORT).show()
            return
        }

        // Si ha ido bien anyadimos el dibujo y sobreescribimos ImageView modificando la imagen a esta nueva y navegamos a ImageView
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