package com.example.rutasanacamacho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rutasanacamacho.conexion.BDFirebase
import com.example.rutasanacamacho.daoRutas.DaoRutasFb
import com.example.rutasanacamacho.entidades.Ruta

class MainActivity : AppCompatActivity() {
    lateinit var  daoRutas: DaoRutasFb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val conexion = BDFirebase(this)
        daoRutas= DaoRutasFb()
        daoRutas.createConexion(conexion)

        pruebas()
    }

    private fun pruebas() {
        Log.d("pruebas", "Añado rutas: ")
        var ruta1= Ruta("Ruta1", "23 34 56", "45 56 78", "Guillena", 30, "")
        var ruta2= Ruta("Ruta2", "54 45 23", "34 23 65" , "Aracena", 16, "")
        daoRutas.addRuta(ruta1)
        daoRutas.addRuta(ruta2)

        Log.d("pruebas", "Veo rutas: ")
        daoRutas.getRutas()
    }


}