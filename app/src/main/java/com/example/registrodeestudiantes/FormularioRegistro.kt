package com.example.registrodeestudiantes

import Clases.Estudiante
import Clases.Operaciones
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class FormularioRegistro : AppCompatActivity() {

    var campoDocumento:EditText?=null
    var campoNombre: EditText?=null
    var campoEdad:EditText?=null
    var campoTelefono:EditText?=null
    var campoDireccion:EditText?=null

    var campoMateria1:EditText?=null
    var campoMateria2:EditText?=null
    var campoMateria3:EditText?=null
    var campoMateria4:EditText?=null
    var campoMateria5:EditText?=null

    var campoNota1:EditText?=null
    var campoNota2:EditText?=null
    var campoNota3:EditText?=null
    var campoNota4:EditText?=null
    var campoNota5:EditText?=null

    var operaciones: Operaciones?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_registro)
        iniciarComponentes()

        val btnsalir: ImageView = findViewById(R.id.iconSalir)
        btnsalir.setOnClickListener{onClick()}
    }

    private fun onClick() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private fun iniciarComponentes() {
        operaciones= Operaciones()

        campoDocumento=findViewById(R.id.txtDocumento)
        campoNombre=findViewById(R.id.txtNombre)
        campoEdad=findViewById(R.id.txtEdad)
        campoTelefono=findViewById(R.id.txtNumero)
        campoDireccion=findViewById(R.id.txtDireccion)

        campoMateria1=findViewById(R.id.txtMateria1)
        campoMateria2=findViewById(R.id.txtMateria2)
        campoMateria3=findViewById(R.id.txtMateria3)
        campoMateria4=findViewById(R.id.txtMateria4)
        campoMateria5=findViewById(R.id.txtMateria5)

        campoNota1=findViewById(R.id.txtNota1)
        campoNota2=findViewById(R.id.txtNota2)
        campoNota3=findViewById(R.id.txtNota3)
        campoNota4=findViewById(R.id.txtNota4)
        campoNota5=findViewById(R.id.txtNota5)

        var btnRegistro: Button =findViewById(R.id.btnCalcular)
        btnRegistro.setOnClickListener { registrarEstudiante() }


    }

    var est:Estudiante= Estudiante()
    var notaInvalida:Boolean=true

    private fun registrarEstudiante() {
        est.documento= campoDocumento?.text.toString().toInt()
        est.nombre=campoNombre?.text.toString()
        est.edad=campoEdad?.text.toString().toInt()
        est.direccion=campoDireccion?.text.toString()
        est.telefono=campoTelefono?.text.toString()

        est.materia1=campoMateria1?.text.toString()
        est.materia2=campoMateria2?.text.toString()
        est.materia3=campoMateria3?.text.toString()
        est.materia4=campoMateria4?.text.toString()
        est.materia5=campoMateria5?.text.toString()

        est.nota1= campoNota1?.text.toString().toDouble()
        est.nota2= campoNota2?.text.toString().toDouble()
        est.nota3= campoNota3?.text.toString().toDouble()
        est.nota4= campoNota4?.text.toString().toDouble()
        est.nota5= campoNota5?.text.toString().toDouble()

        if (est.nota1 < 0 || est.nota1 > 5.0){
            Toast.makeText(this,"La nota 1 no puede ser menor a 0 ni mayor a 5",Toast.LENGTH_LONG).show()
            notaInvalida = false
        }else if (est.nota2 < 0 || est.nota2 > 5.0){
            Toast.makeText(this,"La nota 2 no puede ser menor a 0 ni mayor a 5",Toast.LENGTH_LONG).show()
            notaInvalida = false
        }else if (est.nota3 < 0 || est.nota3 > 5.0){
            Toast.makeText(this,"La nota 3 no puede ser menor a 0 ni mayor a 5",Toast.LENGTH_LONG).show()
            notaInvalida = false
        } else if (est.nota4 < 0 || est.nota4 > 5.0){
            Toast.makeText(this,"La nota 4 no puede ser menor a 0 ni mayor a 5",Toast.LENGTH_LONG).show()
            notaInvalida = false
        }else if (est.nota5 < 0 || est.nota5 > 5.0) {
            Toast.makeText(this, "La nota 5 no puede ser menor a 0 ni mayor a 5", Toast.LENGTH_LONG).show()
            notaInvalida = false
        }
        else{
            est.promedio= operaciones!!.calcularPromedio(est)
            operaciones?.registrarEstudiante(est)
            operaciones?.imprimirListaEstudiantes()
            val intent = Intent(this,Resultado::class.java)
            val miBundle:Bundle= Bundle()

            miBundle.putInt("documentoEstudiante",est.documento)
            miBundle.putString("nombreEstudiante",est.nombre)
            miBundle.putInt("edadEstudiante",est.edad)
            miBundle.putString("direccionEstudiante",est.direccion)
            miBundle.putString("telefonoEstudiante",est.telefono)

            miBundle.putString("materia1",est.materia1)
            miBundle.putString("materia2",est.materia2)
            miBundle.putString("materia3",est.materia3)
            miBundle.putString("materia4",est.materia4)
            miBundle.putString("materia5",est.materia5)

            miBundle.putDouble("nota1", est.nota1)
            miBundle.putDouble("nota2", est.nota2)
            miBundle.putDouble("nota3", est.nota3)
            miBundle.putDouble("nota4", est.nota4)
            miBundle.putDouble("nota5", est.nota5)

            miBundle.putDouble("promedio", est.promedio)

            intent.putExtras(miBundle)
            startActivity(intent)
        }

    }



}