package com.enigma.SondeoPrecios.Ubicacion

class TipoMercado {

	String nombre

	static hasMany = [mercados: Mercado]
    static constraints = {
    	nombre(unique: true)
    }

    String toString(){
    	nombre
    }
}
