package com.enigma.SondeoPrecios.Ubicacion
import com.enigma.SondeoPrecios.Producto.Precio

class Mercado {
    String nombre
    String direccion
    String telefono

    static constraints = {
    	nombre(unique:true)
        direccion()
    	municipio()
        telefono()
    }

    static belongsTo = [municipio : Municipio, tipoMercado: TipoMercado]
    static hasMany = [precios : Precio]

    String toString() {
    	nombre 
    }
}
