package com.example.actividad1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Prueba de espresso para comprobar el funcionamiento UI de la activity de cuestinario
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CuestionarioUITest {

    /**
     * En este test se comprueba que los textInput comiencen vacios, que se escriba correctamente y que funciona al pulsar el boton
     */
    @Test
    fun fieldsAndButtonWorksProperty() {

        ActivityScenario.launch(CuestionarioActivity::class.java)

        //se verifica que no tengan nada al inicializar
        onView(withId(R.id.eName)).check(matches(withText("")))
        onView(withId(R.id.eSerie)).check(matches(withText("")))
        onView(withId(R.id.eURL)).check(matches(withText("")))

        //escribimos en ellos
        onView(withId(R.id.eName)).perform(typeText("Prueba"))
        onView(withId(R.id.eSerie)).perform(typeText("Prueba2"))
        onView(withId(R.id.eURL)).perform(typeText("https://cdn-icons-png.flaticon.com/512/889/889221.png"))

        //cerramos el teclado
        onView(isRoot()).perform(closeSoftKeyboard())

        //verificamos que se halla escrito algo
        onView(withId(R.id.eName)).check(matches(not(withText(""))))
        onView(withId(R.id.eSerie)).check(matches(not(withText(""))))
        onView(withId(R.id.eURL)).check(matches(not(withText(""))))

        //Probamos al pulsar el boton
        onView(withId(R.id.buttonComentar)).perform(click())

    }

}