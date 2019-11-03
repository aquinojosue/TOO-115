package SondeoPrecios

class Precio {
	BigDecimal precio
	Date dateCreated

	static belongsTo = [producto : Producto, ubicacion : Ubicacion]
    static constraints = {
        dateCreated(display: true)
    	producto()
    	ubicacion()
    	precio()
    }
    String toString(){
    	String.valueOf(precio)
    }

}
