package com.example.actividad1.domain

import java.util.regex.Pattern

/**
 * Compilación de un patrón de expresión regular para URLs con soporte para http, https y ftp
  */

private val urlPattern = Pattern.compile(
        "^(https?|ftp)://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w._-]*\\??[^#]*#?.*$",
        Pattern.CASE_INSENSITIVE
)

// Definición de la clase Dibujo
data class Dibujo (
    // Propiedad que almacena el nombre del dibujo
    val name:String,
    // Propiedad que almacena la serie a la que pertenece el dibujo
    val serie:String,
    // Propiedad que almacena la URL de la imagen del dibujo
    val photo:String
) {
    // Bloque de inicialización que se ejecuta cuando se crea una instancia de 'Dibujo'
    init {
        require(urlPattern.matcher(photo).matches())
    }
}