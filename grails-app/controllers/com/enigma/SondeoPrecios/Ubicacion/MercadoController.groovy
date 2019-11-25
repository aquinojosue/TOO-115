package com.enigma.SondeoPrecios.Ubicacion


class MercadoController {

    def index() { 
        
    }
    def create(){

    }
    def save(){
    	def municipio = Municipio.get(params.municipioSelected)
        def tipoMercado = TipoMercado.get(params.tipoMercadoSelected)
    	def mercadoNuevo = new Mercado(
    		nombre:params.nombre,
    		municipio:municipio,
    		direccion:params.direccion,
    		telefono:params.telefono,
            tipoMercado: tipoMercado)
    	try{
    		mercadoNuevo.save flush: true, failOnError: true
    		flash.message = "Mercado \'"+ mercadoNuevo+"\' creado correctamente."
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
    	[editElement : Mercado.get(params.id)]
    }
    def update(){
    	def municipio = Municipio.get(params.municipioSelected)
        def tipoMercado = TipoMercado.get(params.tipoMercadoSelected)
    	try{
	    	def editElement = Mercado.get(params.id)
	    	editElement.nombre = params.nombre
	    	editElement.direccion = params.direccion
	    	editElement.telefono = params.telefono
	    	editElement.municipio = municipio
            editElement.tipoMercado = tipoMercado
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
