package com.enigma.SondeoPrecios.Ubicacion

class MunicipioController {

    def index() { 
    	[municipios : Municipio.list()]
    }
    def create(){
    	[departamentos: Departamento.list()]
    }
    def save(){
    	def departamento = Departamento.get(params.departamentoSelected)
    	def municipioNuevo = new Municipio(nombre:params.nombre,departamento:departamento)
    	try{
    		municipioNuevo.save flush: true, failOnError: true
    		flash.message = "Municipio \'"+ municipioNuevo+"\' creado correctamente."
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
    	[editElement : Municipio.get(params.id),departamentos: Departamento.list()]
    }
    def update(){
    	def departamento = Departamento.get(params.departamentoSelected)
    	try{
	    	def editElement = Municipio.get(params.id)
	    	editElement.nombre = params.nombre
	    	editElement.departamento = departamento
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
		    def deleteElement = Municipio.get(params.id)
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
