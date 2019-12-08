package com.enigma.SondeoPrecios.Seguridad

class UsuarioController {
	def springSecurityService

    def index() {
    	[usuarios: Usuario.list()]
    }
    def create(){
    	[listaRoles: Rol.list()]
    }

    def edit(){
    	def listaRoles = []
    	def usuario = Usuario.get(params.id)
		if(usuario==null){
		    flash.message = "Error: Usuario no encontrado"
		    flash.typeMessage = "danger"
		    redirect(action: "index")
		    return
		}
    	Rol.list().each{ rol->
    		def found = false
    		usuario.getAuthorities().each{ role ->
    			found = (rol.id == role.id)? true: found
    		}
    		listaRoles.add([authority: rol.authority, found: found])
    	}
    	[listaRoles: listaRoles, editElement: usuario]
    }

    def save(){
    	def newElement = new Usuario()
    	try{
    		newElement.firstName = params.firstName
    		newElement.lastName = params.lastName
    		def username = params.username
    		def password = params.password
	    	def rolesAsignados = params.list('rolAsignado')


    		if(username.isEmpty()&&password.isEmpty()){
		    	flash.message = "Error: Los campos de usuario y contraseña no pueden quedar vacíos"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
		    }
    		else if(password.isEmpty()){
		    	flash.message = "Error: El campo de contraseña no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
    		}
    		else if(username.isEmpty()){
		    	flash.message = "Error: El campo de usuario no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
    		}

	    	if(rolesAsignados.isEmpty()){
		    	flash.message = "Error: El campo de rolesAsignados no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return	    		
	    	}


    		newElement.username = username
    		newElement.password = password
    		newElement.email = params.email
	    	newElement.save flush: true, failOnError: true

	    	rolesAsignados.each{ rolAsignado ->
	    		def rolNuevo = new UsuarioRol(usuario: newElement, rol: Rol.findByAuthority(rolAsignado))
	    		rolNuevo.save flush: true, failOnError: true
	    	}

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

    def update(){
    	def editElement = Usuario.get(params.id)
    	try{
    		editElement.firstName = params.firstName
    		editElement.lastName = params.lastName
    		def username = params.username
    		def password = params.password
	    	def rolesAsignados = params.list('rolAsignado')


    		if(username.isEmpty()&&password.isEmpty()){
		    	flash.message = "Error: Los campos de usuario y contraseña no pueden quedar vacíos"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
		    }
    		else if(password.isEmpty()){
		    	flash.message = "Error: El campo de contraseña no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
    		}
    		else if(username.isEmpty()){
		    	flash.message = "Error: El campo de usuario no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return
    		}

	    	if(rolesAsignados.isEmpty()){
		    	flash.message = "Error: El campo de rolesAsignados no debe quedar vacío"
		    	flash.typeMessage = "danger"
		        redirect(action: "index")
		        return	    		
	    	}


    		editElement.username = username
    		editElement.password = password
    		editElement.email = params.email
	    	editElement.save flush: true, failOnError: true

	    	rolesAsignados.each{ rolAsignado ->
	    		def rol = Rol.findByAuthority(rolAsignado)
	    		def found = false
	    		editElement.getAuthorities().each{ role ->
	    			found = (rol?.id == role.id)? true: found
	    		}
	    		if(!found){
	    			def rolNuevo = new UsuarioRol(usuario: editElement, rol: rol)
	    			rolNuevo.save flush: true, failOnError: true
	    		}
	    	}

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
		    def deleteElement = Usuario.get(params.id)
			
			if(deleteElement==null){
				flash.message = "Error: Usuario no encontrado"
				flash.typeMessage = "danger"
				redirect(action: "index")
				return
			}
    		if(params.confirmation != null){
                try {
                	UsuarioRol.findAllByUsuario(deleteElement).each{ userRole ->
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
