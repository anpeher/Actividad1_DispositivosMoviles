package com.example.actividad1.domain

import java.util.regex.Pattern

private val urlPattern = Pattern.compile(
        "^(https?|ftp)://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w._-]*\\??[^#]*#?.*$",
        Pattern.CASE_INSENSITIVE
)

data class Dibujo (
    val name:String,
    val serie:String,
    val photo:String
) {
    init {
        require(urlPattern.matcher(photo).matches())
    }
}