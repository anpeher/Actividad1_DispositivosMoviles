package com.example.actividad1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Prueba de espresso para comprobar el funcionamiento UI de la activity de ImageActivity
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ImageActivityUITest {
    /**
     * En este test se comprueba que la imagen y el texto se vea correctamente
     * además, para el texto también comprobamos que ponga el mensaje adecuado y que no este vacío
     */
    @Test
    fun imageAndTextWorksProperty() {

        ActivityScenario.launch(ImageActivity::class.java)

        // Verificar que el ImageView es visible
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(not(withText(""))))
        onView(withId(R.id.textView)).check(matches(withText("Aquí se mostrara la última imagen añadida")))

    }
}