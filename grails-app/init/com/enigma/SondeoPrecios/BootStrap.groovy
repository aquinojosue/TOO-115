package com.enigma.SondeoPrecios
import com.enigma.SondeoPrecios.Producto.*
import com.enigma.SondeoPrecios.Ubicacion.*
import com.enigma.SondeoPrecios.Seguridad.*

class BootStrap {
    def springSecurityService
    def controllerService

    def init = { servletContext ->

    	new Marca(nombre: 'Issima', descripcion: 'buenos productos').save()
    	new Categoria(nombre: 'Granos Básicos').save()
    	new Categoria(nombre: 'Productos Básicos').save()
    	new Categoria(nombre: 'Harinas').save()
    	new Categoria(nombre: 'Frutas, Verduras, carnes y huevos').save()
    	new Categoria(nombre: 'Útiles escolares').save()
    	new UnidadMedida(nombre: 'Mililitros',representacion:'mL').save()
    	new Presentacion(nombre: 'Bolsa').save()
        def supermercado = new TipoMercado(nombre:'Supermercado').save()
        new TipoMercado(nombre: 'Mercado municipal').save()

        def sanSalvador = new Departamento(nombre: 'San Salvador').save()
        def ilopango = new Municipio(nombre: 'Ilopango', departamento: sanSalvador).save()
        new Mercado(nombre: 'Super Selectos Santa Lucia', municipio: ilopango,direccion:'una calle algo',telefono:'22948579', tipoMercado: supermercado).save()

        //Creación de usuarios y roles
        Usuario admin2 = new Usuario(username:'admin', password: 'admin', firstName: 'Administrador', lastName: 'Sistema', email: 'admin@localhost').save()
        Usuario admin = new Usuario(username:'jaquino', password: 'admin', firstName: 'Josué', lastName: 'Aquino', email: 'aquino@localhost').save()
        Rol user = new Rol(authority: 'ROLE_USER').save()
        Rol adminRole = new Rol(authority: 'ROLE_ADMIN').save()
        new Rol(authority: 'ROLE_CUSTOMER').save()
        UsuarioRol.create(admin,user)
        UsuarioRol.create(admin2,adminRole)

        //Agregando permisos para acceso publico
        for (String url in [
            '/', '/error', '/index', '/index.gsp', '/**/favicon.ico', '/shutdown',
            '/assets/**', '/**/js/**', '/**/css/**', '/**/images/**',
            '/login', '/login.*', '/login/*','/home/**', '/tablaprecios/**',
            '/logout', '/logout.*', '/logout/*']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save()
        }     
        
        //Agregar todos los roles al controller admin
        def adminController = Requestmap.findByUrl('/admin/**')
        if(adminController!=null){
            adminController.configAttribute = Rol.list().join(", ")        
            adminController.save flush: true, failOnError: true
        }
        else {
            new Requestmap(url: '/admin/**', configAttribute: Rol.list().join(", ")).save()
        }
        
        //Agregando permisos de los controllers para el rol admin
        String filtro = "login, logout, home, tablaprecios"
        controllerService.serviceMethod().each{ controlador ->
            String uri = ""
            if(!filtro.split(", ").contains(controlador.controller))
                uri = "/"+controlador.controller+"/**"
            new Requestmap(url: uri, configAttribute: 'ROLE_ADMIN').save()
        }
        // //Editar el "prueba" par
        //Requestmap prueba = Requestmap.findByUrl('/producto/**')
        //prueba?.configAttribute = 'ROLE_ADMIN, ROLE_USER'
        //prueba?.save flush: true, failOnError: true
        
        springSecurityService.clearCachedRequestmaps()

    }
    def destroy = {
    }
}
