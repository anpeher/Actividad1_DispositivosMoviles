package com.example.actividad1

import com.example.actividad1.domain.Dibujo
import junit.framework.TestCase.assertNotNull
import org.junit.Test
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CuestionarioActivityTest {
    private lateinit var dibujo: Dibujo

    @Test(expected = IllegalArgumentException::class)
    fun create_dibujo_with_non_valid_url() {
        val url = "http/:/wrong.url.com"
        dibujo = Dibujo("Test", "TestSerie", url)
    }

    @Test
    fun create_dibujo() {
        val url = "http://valid-url.com"
        dibujo = Dibujo("Test", "TestSerie", url)
        assertNotNull(dibujo)
    }
}