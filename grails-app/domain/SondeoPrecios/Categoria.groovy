package SondeoPrecios

class Categoria {
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
