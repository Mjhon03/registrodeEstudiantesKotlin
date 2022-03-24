package com.example.registrodeestudiantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRegistrodeEstudiante:Button = findViewById(R.id.btnInicioRegistro)
        btnRegistrodeEstudiante.setOnClickListener{onClick(1)}
        val btnEstadisticas:Button = findViewById(R.id.btnEstadisticas)
        btnEstadisticas.setOnClickListener{onClick(2)}
        val btnAyuda :Button = findViewById(R.id.btnAyuda)
        btnAyuda.setOnClickListener{onClick(3)}

    }

    private fun onClick(boton: Int) {

        when(boton){
            1->{
                val intent = Intent(this,FormularioRegistro::class.java)
                startActivity(intent)
            }
            2->{
                val intent = Intent(this,Estadisticas::class.java)
                startActivity(intent)
            }
            3->{
                val intent = Intent(this,Ayuda::class.java)
                startActivity(intent)
            }
        }

    }
}