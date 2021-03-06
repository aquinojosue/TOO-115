package com.enigma.SondeoPrecios.Producto

class UnidadMedida {
    String nombre
    String representacion

    static hasMany = [productos : Producto]
    static constraints = {
    	nombre(unique:true)
    	representacion()
    	productos()
    }

    String toString(){
    	representacion
    }
}
