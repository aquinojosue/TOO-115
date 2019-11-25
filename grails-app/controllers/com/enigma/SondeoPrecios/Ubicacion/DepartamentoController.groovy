package com.enigma.SondeoPrecios.Ubicacion


class DepartamentoController {

    def index() { 
    	[departamentos : Departamento.list()]
    }
    def create(){

    }
    def save(){
    	def depNuevo = new Departamento(nombre: params.nombre)
    	try{
    		depNuevo.save flush: true, failOnError: true
    		flash.message = "Departamento \'"+ depNuevo+"\' creado correctamente."
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
    	[editElement : Departamento.get(params.id)]
    }
    def update(){
    	try{
	    	def editElement = Departamento.get(params.id)
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
		    def deleteElement = Departamento.get(params.id)
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
