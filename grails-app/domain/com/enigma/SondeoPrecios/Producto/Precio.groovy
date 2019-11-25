package com.enigma.SondeoPrecios.Producto
import com.enigma.SondeoPrecios.Ubicacion.Mercado

class Precio {
    BigDecimal precio
    Date dateCreated

    static belongsTo = [producto : Producto, mercado : Mercado]
    static constraints = {
        dateCreated(display: true)
    	producto()
    	mercado()
    	precio()
    }
    String toString(){
    	String.valueOf(precio)
    }

}
