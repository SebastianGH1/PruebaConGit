package model

class Rectangulo(var color:Int , var ancho:Int , var alto:Int) {

    //cordenadas iniciales

    var x:Int=0

    var y:Int=0

    //Metodos (comportamientos del rectangulo)

    fun moverArriba(){
        y-=10
    }

    fun moverAbajo(){
        y+=10
    }

    fun moverDerecho(){
        x+=10
    }

    fun moverIzquierda(){
        x-=10
    }

    //metodo para cambiar tamaño
    fun cambiarTamaño(nuevoAncho:Int , nuevoAlto:Int){
        ancho=nuevoAncho
        alto=nuevoAlto

    }

}