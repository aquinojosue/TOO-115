package com.enigma.SondeoPrecios.Producto

class Presentacion {
    String nombre

    static hasMany = [productos : Producto]
    static constraints = {
    	nombre(unique:true)
    	productos()
    }

    String toString(){
    	nombre 
    }
}
