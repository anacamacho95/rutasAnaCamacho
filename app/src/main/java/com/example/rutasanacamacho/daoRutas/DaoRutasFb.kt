package com.example.rutasanacamacho.daoRutas

import android.util.Log
import com.example.rutasanacamacho.conexion.BDFirebase
import com.example.rutasanacamacho.entidades.Ruta
import com.example.rutasanacamacho.interfaces.InterfaceDaoConexion
import com.example.rutasanacamacho.interfaces.InterfaceDaoRutas
import com.google.firebase.firestore.FirebaseFirestore

class DaoRutasFb: InterfaceDaoRutas, InterfaceDaoConexion {

    lateinit var conexion: FirebaseFirestore

    override fun createConexion(con: BDFirebase) {
        conexion= (con as BDFirebase).conexion
    }

    override fun addRuta(ruta: Ruta) {
        conexion.collection("rutas")
            .add(ruta)
            .addOnSuccessListener { documentReference ->
                val idDocumento = documentReference.id

                conexion.collection("rutas").document(idDocumento)
                    .update("idRuta", idDocumento)
                    .addOnSuccessListener {
                        ruta.idRuta = documentReference.id
                        Log.d("pruebas", "La ruta se ha creado correctamente")
                    }
                    .addOnFailureListener { e ->
                        // Manejar el error de actualización
                    }
            }
            .addOnFailureListener { e ->
                // Manejar el error de creación
            }
    }

    override fun getRutas() {
        var  rutas: MutableList<Ruta> = mutableListOf()
        conexion.collection("rutas")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val ruta = document.toObject(Ruta::class.java)
                        rutas.add(ruta)
                    }
                    //aqui es donde se muestran los resultados. Los del main no tienen datos aún. Esto es un metodo asincrono
                    rutas.forEach {
                        Log.d("pruebas",it.nombre)
                    }
                }
                else {
                    Log.d("pruebas", "Error al obtener documentos.", task.exception)
                }
            }
    }



}