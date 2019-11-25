package com.enigma.SondeoPrecios.Producto
import com.enigma.SondeoPrecios.Ubicacion.Mercado

class PrecioController {

    def index() { 
    	[precios : Precio.list()]
    }
    def create(){
    	[mercados: Mercado.list(),productos: Producto.list()]
    }
    def save(){
    	def mercado = Mercado.get(params.mercadoSelected)
    	def producto = Producto.get(params.productoSelected)
    	def precioNuevo = new Precio(
    		precio:params.precio,
    		producto: producto,
    		mercado: mercado)
    	try{
    		precioNuevo.save flush: true, failOnError: true
    		flash.message = "Precio \'"+ precioNuevo+"\' para el producto \'"+producto+"\' agregado correctamente."
	    	flash.typeMessage = "success"
        	redirect(action: "index")
    	}
    	catch(Exception e){
    		flash.message = "Error, el error es " + e
	    	flash.typeMessage = "danger"
	        redirect(action: "index")
    	}
    }
    def edit(){
    	[editElement : Mercado.get(params.id),municipios: Municipio.list()]
    }
    def update(){
    	def municipio = Municipio.get(params.municipioSelected)
    	try{
	    	def editElement = Mercado.get(params.id)
	    	editElement.nombre = params.nombre
	    	editElement.direccion = params.direccion
	    	editElement.telefono = params.telefono
	    	editElement.municipio = municipio
	    	editElement.save flush: true, failOnError: true
	    	flash.message = "Los cambios se guardaron con éxito."
	    	flash.typeMessage = "success"
	        redirect(action: "index")
    	}
    	catch(Exception e){
    		flash.message = "Error, el error es " + e
	    	flash.typeMessage = "danger"
	        redirect(action: "index")
    	}
    }
    def delete(){
    	if(params.id != null){
		    def deleteElement = Mercado.get(params.id)
    		if(params.confirmation != null){
                try {   
                    deleteElement.delete flush: true, failOnError: true
                    flash.message = "Los cambios se han guardado correctamente."
                    flash.typeMessage = "success"
                }
                catch(Exception e){
                    flash.message = "Error, el error es " + e
                    flash.typeMessage = "danger"
                }
		    	redirect(action:"index")
    		}
    		else {
    			[deleteElement : deleteElement]
    		}
    	}
    	else{
    		redirect(action:"index")
    	}
    }
}
