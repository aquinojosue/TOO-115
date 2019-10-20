package sondeoprecios

import SondeoPrecios.Rol
import SondeoPrecios.Usuario
import SondeoPrecios.UsuarioRol
class BootStrap {

    def init = { servletContext ->

    	new Rol(authority: 'ROLE_CUSTOMER').save()
    	new Rol(authority: 'ROLE_USER').save()
    	def roleAdmin = new Rol(authority: 'ROLE_ADMIN').save()

		def adminUser = new Usuario(username: 'admin', password: 'admin123', nomUsuario: 'Administrador', apeUsuario: 'Sistema', email: 'admin@localhost').save()
		def adminUser2 = new Usuario(username: 'admin2', password: 'admin123', nomUsuario: 'Administrador', apeUsuario: 'Dos', email: 'admin@localhost').save()        	
    
		UsuarioRol.create adminUser, roleAdmin
        UsuarioRol.create adminUser2, roleAdmin
        
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
