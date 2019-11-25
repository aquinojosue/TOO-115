package com.enigma.SondeoPrecios.Ubicacion

class TipoMercadoController {

    def index()  { }
    def create() { }
    
    def save(){
    	def tipoMercadoNuevo = new TipoMercado(nombre: params.nombre)
    	try{
    		tipoMercadoNuevo.save flush: true, failOnError: true
    		flash.message = "Tipo de mercado  \'"+ tipoMercadoNuevo+"\' creado correctamente."
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
    	[editElement : TipoMercado.get(params.id)]
    }
    def update(){
    	try{
	    	def editElement = TipoMercado.get(params.id)
	    	editElement.properties = params
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
		    def deleteElement = TipoMercado.get(params.id)
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
