package com.example.rutasanacamacho.conexion

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class BDFirebase(private val context: Context) {
    val conexion = Firebase.firestore
}