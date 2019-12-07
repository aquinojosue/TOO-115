package com.enigma.SondeoPrecios.Seguridad

class RolController {

    def index() { 
        [listaRoles: Rol.list()]
    }
    def save(){
        try{
            String authority = params.authority
            if(authority.isEmpty()){
                flash.message = "Error: el nombre del rol no debe ir vacío"
                flash.typeMessage = "danger"
                redirect(action: "index")
                return
            }

            def newElement = new Rol()
            newElement.authority = params.authority
            newElement.save flush: true, failOnError: true

            flash.message = "El rol fue creado con éxito"
            flash.typeMessage = "success"
        }
        catch (Exception e){
            flash.message = "Error, el error es " + e
            flash.typeMessage = "danger"
        }
        redirect(action: "index")
    }
    def create(){}

    def edit(){
        def editElement = Rol.get(params.id)
        if(editElement == null){
            flash.message = "Error: no se pudo encontrar el rol."
            flash.typeMessage = "danger"
            redirect(action: "index")
            return
        }
        [editElement: editElement]
    }
    def update(){
        try{
            String authority = params.authority
            def editElement = Rol.get(params.id)
            if(authority.isEmpty()){
                flash.message = "Error: el nombre del rol no debe ir vacío"
                flash.typeMessage = "danger"
                redirect(action: "index")
                return
            }
            editElement.authority = authority
	    	editElement.save flush: true, failOnError: true

            flash.message = "Los cambios fueron realizados con éxito"
            flash.typeMessage = "success"
        }
        catch (Exception e){
            flash.message = "Error, el error es " + e
            flash.typeMessage = "danger"
        }
        redirect(action: "index")
    }

    def delete(){
    	if(params.id != null){
		    def deleteElement = Rol.get(params.id)
			
			if(deleteElement==null){
				flash.message = "Error: Usuario no encontrado"
				flash.typeMessage = "danger"
				redirect(action: "index")
				return
			}
    		if(params.confirmation != null){
                try {
                	UsuarioRol.findAllByRol(deleteElement).each{ userRole ->
                		userRole.delete flush:true, failOnError: true
                	}
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
