package com.example.actividad1

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CuestionarioActivityTest {
    private lateinit var cuestionarioActivity: CuestionarioActivity

    @Before
    fun setUp() {
        cuestionarioActivity = CuestionarioActivity()
    }

    @Test
    fun image_url_validation_non_complient_with_regex() {
        val url = "http/:/wrong.url.com"

        val method = CuestionarioActivity::class.java.getDeclaredMethod("isValidUrl")
        method.apply {
            isAccessible = true
        }
        val params = arrayOfNulls<String>(1)
        params[0] = url
        assertEquals(true, method.invoke(cuestionarioActivity, *params))
    }
}