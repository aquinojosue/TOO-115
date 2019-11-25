package com.enigma.SondeoPrecios.Producto

class PresentacionController {

    def index() { 
    	[presentaciones : Presentacion.list()]
    }
    def create(){

    }
    def save(){
    	def presentacionNueva = new Presentacion(params)
    	try{
    		presentacionNueva.save flush: true, failOnError: true
    		flash.message = "Presentación \'"+ presentacionNueva+"\' creada correctamente."
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
    	[editElement : Presentacion.get(params.id)]
    }
    def update(){
    	try{
	    	def editElement = Presentacion.get(params.id)
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
		    def deleteElement = Presentacion.get(params.id)
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
