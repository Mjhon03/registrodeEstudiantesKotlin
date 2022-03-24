package Clases

class Operaciones {
    companion object{
        var listaEstudiantes =arrayListOf<Estudiante>()
        var listaEstudiantesGanan = arrayListOf<Estudiante>()
        var listaEstudiantesPierden = arrayListOf<Estudiante>()
        var listaEstudiantesRecuperan = arrayListOf<Estudiante>()
    }

    fun registrarEstudiante(estudiante: Estudiante){
        if (estudiante.promedio>3.5)
        {
            listaEstudiantes.add(estudiante)
            listaEstudiantesGanan.add(estudiante)
        }else if(estudiante.promedio>2.5 && estudiante.promedio<3.5){
            listaEstudiantes.add(estudiante)
            listaEstudiantesRecuperan.add(estudiante)
        }else if(estudiante.promedio<2.5){
            listaEstudiantes.add(estudiante)
            listaEstudiantesPierden.add(estudiante)
        }

    }

    fun registrarEstudianteGanan(estudiante: Estudiante){
        listaEstudiantesGanan.add(estudiante)
    }

    fun registrarEstudiantePierden(estudiante: Estudiante){
        listaEstudiantesPierden.add(estudiante)
    }

    fun registrarEstudianteRecuperan(estudiante: Estudiante){
        listaEstudiantesRecuperan.add(estudiante)
    }
    fun imprimirListaEstudiantes(){
        for(est in listaEstudiantes){
            println(est)
        }
    }

    fun calcularPromedio(est: Estudiante): Double {

        val prom=(est.nota1+est.nota2+est.nota3+est.nota4+est.nota5)/5

        return prom
    }
}