package com.example.actividad1

import com.example.actividad1.domain.Dibujo
import junit.framework.TestCase.assertNotNull
import org.junit.Test
/**
 * Prueba de Junit para comprobar el domain/Dibujo, que se encarga de validar URL´s
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CuestionarioActivityTest {
    private lateinit var dibujo: Dibujo

    /**
     * Valida que no se acepte URL´s incorrectas
     */
    @Test(expected = IllegalArgumentException::class)
    fun createDibujowithNonValidUrl() {
        val url = "http/:/wrong.url.com"
        dibujo = Dibujo("Test", "TestSerie", url)
    }

    /**
     * Valida que se acepte URL´s correctas
     */
    @Test
    fun createDibujo() {
        val url = "http://valid-url.com"
        dibujo = Dibujo("Test", "TestSerie", url)
        assertNotNull(dibujo)
    }
}