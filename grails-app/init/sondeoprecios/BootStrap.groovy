package sondeoprecios

import SondeoPrecios.Rol
import SondeoPrecios.Usuario
import SondeoPrecios.UsuarioRol
class BootStrap {

    def init = { servletContext ->

    	new Rol(authority: 'ROLE_CUSTOMER').save()
    	new Rol(authority: 'ROLE_USER').save()
    	def roleAdmin = new Rol(authority: 'ROLE_ADMIN').save()

		def ab15002 = new Usuario(
			username: 'ab15002', 
			password: 'admin123', 
			nomUsuario: 'Josué', 
			apeUsuario: 'Aquino', 
			email: 'ab15002@localhost'
			).save()

		def av12013 = new Usuario(
			username: 'av12013', 
			password: 'admin123', 
			nomUsuario: 'Celina', 
			apeUsuario: 'Viscarra', 
			email: 'av12013@localhost'
			).save()

		def cm13106 = new Usuario(
			username: 'cm13106', 
			password: 'admin123', 
			nomUsuario: 'Iveth', 
			apeUsuario: 'Carranza', 
			email: 'cm13106@localhost'
			).save()

		def ce12006 = new Usuario(
			username: 'ce12006', 
			password: 'admin123', 
			nomUsuario: 'Elsy', 
			apeUsuario: 'Castro', 
			email: 'ce12006@localhost'
			).save()
			
		def vn10004 = new Usuario(
			username: 'vn10004', 
			password: 'admin123', 
			nomUsuario: 'Alexis', 
			apeUsuario: 'Vásquez', 
			email: 'vn10004@localhost'
			).save()	

		def adminUser = new Usuario(
			username: 'admin', 
			password: 'admin123', 
			nomUsuario: 'Administrador', 
			apeUsuario: 'Sistema', 
			email: 'admin@localhost'
			).save()        	
    
		UsuarioRol.create ab15002, roleAdmin
        UsuarioRol.create av12013, roleAdmin
        UsuarioRol.create cm13106, roleAdmin
        UsuarioRol.create ce12006, roleAdmin
        UsuarioRol.create vn10004, roleAdmin
        UsuarioRol.create adminUser, roleAdmin
        
		UsuarioRol.withSession {
			it.flush()
			it.clear()
		}


		/* println "Creando usuarios..."
		def count = Usuario.count()

		println "usuario ${count}" */
    }
    def destroy = {
    }
}
