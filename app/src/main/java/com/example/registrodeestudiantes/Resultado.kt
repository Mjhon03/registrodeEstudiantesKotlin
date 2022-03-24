package com.example.registrodeestudiantes

import Clases.Estudiante
import Clases.Operaciones
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Resultado : AppCompatActivity() {
    private var promedio: Double? = null
    var est: Estudiante = Estudiante()
    var operaciones: Operaciones?=null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btnsalir: ImageView = findViewById(R.id.iconSalir)
        btnsalir.setOnClickListener{onClick()}

        val campoResultado=findViewById<TextView>(R.id.txtresultadoPromedio)
        val campoInformacion=findViewById<TextView>(R.id.txtResultado)
        val miBundle:Bundle? = this.intent.extras

        promedio = miBundle?.getDouble("promedio")

        est.documento = miBundle?.getInt("documentoEstudiante")!!
        est.nombre = miBundle.getString("nombreEstudiante")!!
        est.edad = miBundle.getInt("edadEstudiante")!!
        est.direccion = miBundle.getString("direccionEstudiante")!!
        est.telefono = miBundle.getString("telefonoEstudiante")!!

        est.materia1 = miBundle.getString("materia1")!!
        est.materia2 = miBundle.getString("materia2")!!
        est.materia3 = miBundle.getString("materia3")!!
        est.materia4 = miBundle.getString("materia4")!!
        est.materia5 = miBundle.getString("materia5")!!

        est.nota1 = miBundle.getDouble("nota1")
        est.nota2 = miBundle.getDouble("nota2")
        est.nota3 = miBundle.getDouble("nota3")
        est.nota4 = miBundle.getDouble("nota4")
        est.nota5 = miBundle.getDouble("nota5")


        if (promedio!! >= 3.5){
            if (miBundle != null){
                campoInformacion.text="Numero de documento: ${miBundle.getInt("documentoEstudiante")}\n" +
                        "Estudiante: ${miBundle.getString("nombreEstudiante")}\n" +
                        "Edad: ${miBundle.getInt("edadEstudiante")}\n" +
                        "Telefono: ${miBundle.getString("telefonoEstudiante")}\n" +
                        "Direccion: ${miBundle.getString("direccionEstudiante")}\n" +
                        "Materia 1: ${miBundle.getString("materia1")} nota: ${miBundle.getDouble("nota1")}\n" +
                        "Materia 2: ${miBundle.getString("materia2")} nota: ${miBundle.getDouble("nota2")}\n" +
                        "Materia 3: ${miBundle.getString("materia3")} nota: ${miBundle.getDouble("nota3")}\n" +
                        "Materia 4: ${miBundle.getString("materia4")} nota: ${miBundle.getDouble("nota4")}\n" +
                        "Materia 5: ${miBundle.getString("materia5")} nota: ${miBundle.getDouble("nota5")}\n" +
                        "Promedio general: ${miBundle.getDouble("promedio")}\n"

                campoResultado.text ="El estudiante ha ganado el periodo"
            }
        }else if (promedio!!<3.5 && promedio!! > 2.5){
            if (miBundle != null){
                campoInformacion.text="Numero de documento: ${miBundle.getInt("documentoEstudiante")}\n" +
                        "Estudiante: ${miBundle.getString("nombreEstudiante")}\n" +
                        "Edad: ${miBundle.getInt("edadEstudiante")}\n" +
                        "Telefono: ${miBundle.getString("telefonoEstudiante")}\n" +
                        "Direccion: ${miBundle.getString("direccionEstudiante")}\n" +
                        "Materia 1: ${miBundle.getString("materia1")} nota: ${miBundle.getDouble("nota1")}\n" +
                        "Materia 2: ${miBundle.getString("materia2")} nota: ${miBundle.getDouble("nota2")}\n" +
                        "Materia 3: ${miBundle.getString("materia3")} nota: ${miBundle.getDouble("nota3")}\n" +
                        "Materia 4: ${miBundle.getString("materia4")} nota: ${miBundle.getDouble("nota4")}\n" +
                        "Materia 5: ${miBundle.getString("materia5")} nota: ${miBundle.getDouble("nota5")}\n" +
                        "Promedio general: ${miBundle.getDouble("promedio")}\n"

                campoResultado.text ="El estudiante ha perdido el periodo pero tiene la opcion de recuperar"
                }
        }else if (promedio!!<2.5){
                if (miBundle != null){
                    campoInformacion.text="Numero de documento: ${miBundle.getInt("documentoEstudiante")}\n" +
                            "Estudiante: ${miBundle.getString("nombreEstudiante")}\n" +
                            "Edad: ${miBundle.getInt("edadEstudiante")}\n" +
                            "Telefono: ${miBundle.getString("telefonoEstudiante")}\n" +
                            "Direccion: ${miBundle.getString("direccionEstudiante")}\n" +
                            "Materia 1: ${miBundle.getString("materia1")} nota: ${miBundle.getDouble("nota1")}\n" +
                            "Materia 2: ${miBundle.getString("materia2")} nota: ${miBundle.getDouble("nota2")}\n" +
                            "Materia 3: ${miBundle.getString("materia3")} nota: ${miBundle.getDouble("nota3")}\n" +
                            "Materia 4: ${miBundle.getString("materia4")} nota: ${miBundle.getDouble("nota4")}\n" +
                            "Materia 5: ${miBundle.getString("materia5")} nota: ${miBundle.getDouble("nota5")}\n" +
                            "Promedio general: ${miBundle.getDouble("promedio")}\n"

                    campoResultado.text="El estudiante ha perdido el periodo sin la posibilidad a recuperar"
                    }
        }


    }

    private fun onClick() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}