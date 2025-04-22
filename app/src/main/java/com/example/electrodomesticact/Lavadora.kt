package com.example.electrodomesticact


open class Electrodomestico(
    val marca: String,
    val modelo: String,
    var encendido: Boolean = false
)

{
    open fun encender() {
        encendido = true
    }

    open fun apagar() {
        encendido = false
    }

    fun estado() =

    if (encendido) "Encendido"
    else "Apagado"
}


class Lavadora(
    marca: String,
    modelo: String,
    var capacidadKg: Int,
    var cargaSuperior: Boolean,
    var programaActual: String? = null
) : Electrodomestico(marca, modelo) {

    fun seleccionarPrograma(programa: String) {
        programaActual = programa
    }

    fun iniciarLavado(): String {
        return if (programaActual != null) {
            encender()
            "Iniciando lavado con el programa '$programaActual'"
        } else {
            "Error: No se ha seleccionado ningún programa."
        }
    }

    fun detenerLavado(): String {
        apagar()
        return "Lavado detenido."
    }
}

