package SondeoPrecios

class Ubicacion {
	String nombre
    String direccion

    static constraints = {
    	nombre(unique:true)
        direccion()
    	municipio()
    }

    static belongsTo = [municipio : Municipio]
	static hasMany = [precios : Precio]

    String toString() {
    	nombre 
    }
}
