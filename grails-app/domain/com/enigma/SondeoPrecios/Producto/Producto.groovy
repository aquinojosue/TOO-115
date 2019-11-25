package com.enigma.SondeoPrecios.Producto

class Producto {
    String nombre
    int cantidad

    static hasMany = [precios : Precio]
    static belongsTo = [categoria : Categoria, marca : Marca, presentacion : Presentacion, unidadMedida : UnidadMedida]
    static constraints = {
    	nombre()
    	categoria()
    	marca()
    	presentacion()
    	cantidad()
    	unidadMedida()
    	precios()
    }

    String toString(){
    	nombre + " " + marca
    }
    static mapping = {
        precios sort: 'dateCreated', order: 'desc'
    }
}
