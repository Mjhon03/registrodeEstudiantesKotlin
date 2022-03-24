package com.example.registrodeestudiantes

import Clases.Operaciones
import Clases.Operaciones.Companion.listaEstudiantes
import Clases.Operaciones.Companion.listaEstudiantesGanan
import Clases.Operaciones.Companion.listaEstudiantesPierden
import Clases.Operaciones.Companion.listaEstudiantesRecuperan
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class Estadisticas : AppCompatActivity() {
    var operaciones: Operaciones?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        operaciones = Operaciones()
        val cantidadEstudiantes:Int=listaEstudiantes.count()
        val cantidadEstudianteGanan:Int=listaEstudiantesGanan.count()
        val cantidadEstudiantePierden:Int=listaEstudiantesPierden.count()
        val cantidadEstudianteRecuperan:Int=listaEstudiantesRecuperan.count()

        val inputCantidad:TextView=findViewById(R.id.txtNumcantidadEstudiantes)
        val inputcantidadGanan:TextView=findViewById(R.id.txtNumcantidadEstudiantesganan)
        val inputCantidadPierden:TextView=findViewById(R.id.txtNumcantidadEstudiantespierden)
        val inputCantidadRecuperan:TextView=findViewById(R.id.txtNumcantidadEstudiantesrecuperan)

        inputCantidad.text= cantidadEstudiantes.toString()
        inputcantidadGanan.text=cantidadEstudianteGanan.toString()
        inputCantidadPierden.text=cantidadEstudiantePierden.toString()
        inputCantidadRecuperan.text=cantidadEstudianteRecuperan.toString()

//        estadisticas()
    }

//    private fun estadisticas() {
//
//
//        operaciones?.imprimirListaEstudiantes()
//        Toast.makeText(this, cantidadEstudiantes,Toast.LENGTH_LONG).show()
//    }
}