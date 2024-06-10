package com.example.rutasanacamacho.interfaces

import com.example.rutasanacamacho.entidades.Ruta

interface InterfaceDaoRutas {
    fun addRuta(ruta: Ruta)
    fun getRutas()
}