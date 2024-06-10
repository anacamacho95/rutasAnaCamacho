package com.example.rutasanacamacho.interfaces

import com.example.rutasanacamacho.conexion.BDFirebase

interface InterfaceDaoConexion {
    fun createConexion(con: BDFirebase)
}