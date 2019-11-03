package sondeoprecios
import SondeoPrecios.*

class TablaPreciosController {

    def index(){
    	def productos = Producto.list()
    	def ubicaciones = Ubicacion.list()
    	def datos = []

    	productos.each{ producto ->
    		ubicaciones.each { ubicacion ->
	    		def precios = Precio.findAllByUbicacionAndProducto(
	    			ubicacion,
	    			producto,
	    			[sort:'dateCreated',order:'desc']
	    		)
	    		if(!precios.isEmpty()){
	    			def precio = precios.first()
		    		def row = [ubicacion : precio.ubicacion, producto : precio.producto, precio: precio]
		    		datos.add(row)
	    		}

    		}
    	}
        [datos : datos]
    }
}
