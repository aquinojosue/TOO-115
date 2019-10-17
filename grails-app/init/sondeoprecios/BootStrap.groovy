package sondeoprecios

import SondeoPrecios.Rol
import SondeoPrecios.Usuario
import SondeoPrecios.UsuarioRol
class BootStrap {

    def init = { servletContext ->
    	def roleAdmin = new Rol(authority: 'ROLE_ADMIN').save()
		def adminUser = new Usuario(username: 'admin', password: 'admin123').save()    	
    
		UsuarioRol.create adminUser, roleAdmin
    
		UsuarioRol.withSession {
			it.flush()
			it.clear()
		}


		println "Creando usuarios..."
		def count = Usuario.count()

		println "usuario ${count}"
    }
    def destroy = {
    }
}
