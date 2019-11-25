package com.enigma.SondeoPrecios.Producto

class UnidadmedidaController {

    def index() { 
    	[unidades : UnidadMedida.list()]
    }
    def create(){

    }
    def save(){
    	def nuevaUnidad = new UnidadMedida(params)
    	try{
    		nuevaUnidad.save flush: true, failOnError: true
    		flash.message = "Unidad de medida \'"+ nuevaUnidad+"\' creada correctamente."
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
    	[editElement : UnidadMedida.get(params.id)]
    }
    def update(){
    	try{
	    	def editElement = UnidadMedida.get(params.id)
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
		    def deleteElement = UnidadMedida.get(params.id)
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
