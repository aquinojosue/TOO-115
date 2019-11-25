package com.enigma.SondeoPrecios.Ubicacion

class Municipio {
    String nombre

    static constraints = {
    	nombre(unique:true)
    	departamento()
    	mercados()
    }

    static belongsTo = [departamento : Departamento]
    static hasMany = [mercados : Mercado]

    String toString() {
    	nombre 
    }
}
