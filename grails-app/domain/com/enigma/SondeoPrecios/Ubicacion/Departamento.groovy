package com.enigma.SondeoPrecios.Ubicacion

class Departamento {
    String nombre

    static constraints = {
    	nombre(unique:true)
    	municipios()
    }

    static hasMany = [municipios : Municipio]

    String toString() {
    	nombre 
    }
}
