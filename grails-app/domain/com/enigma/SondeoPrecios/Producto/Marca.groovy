package com.enigma.SondeoPrecios.Producto

class Marca {
    String nombre
    String descripcion

    static hasMany = [productos : Producto]
    static constraints = {
    	nombre(unique:true)
    	descripcion()
    	productos()
    }

    String toString(){
    	nombre 
    }
}
