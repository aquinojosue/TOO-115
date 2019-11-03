package SondeoPrecios

class Municipio {
	String nombre

    static constraints = {
    	nombre(unique:true)
    	departamento()
    	ubicaciones()
    }

    static belongsTo = [departamento : Departamento]
    static hasMany = [ubicaciones : Ubicacion]

    String toString() {
    	nombre 
    }
}
