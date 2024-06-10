package com.example.rutasanacamacho.entidades

class Ruta( var nombre: String, var longInicial: String, var latInicial: String, var rumbo: String, var distancia: Int, var idRuta: String= "" ) {

    override fun toString(): String {
        return "Ruta(nombre='$nombre', longInicial='$longInicial', latInicial='$latInicial', rumbo='$rumbo', distancia=$distancia, idRuta='$idRuta')"
    }

}