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
        Usuario admin = new Usuario(username:'admin', password: 'admin', firstName: 'Administrador', lastName: 'Sistema', email: 'admin@localhost').save()
        Usuario ab15002 = new Usuario(
            username:'ab15002',
            password: 'admin',
            firstName: 'Josué',
            lastName: 'Aquino',
            email: 'ab15002@localhost'
        ).save()
        Usuario av12013 = new Usuario(
            username:'av12013',
            password: 'admin',
            firstName: 'Celina',
            lastName: 'Viscarra',
            email: 'av12013@localhost'
        ).save()
        Usuario cm13016 = new Usuario(
            username:'cm13016',
            password: 'admin',
            firstName: 'Iveth',
            lastName: 'Carranza',
            email: 'cm13016@localhost'
        ).save()
        Usuario ce12006 = new Usuario(
            username:'ce12006',
            password: 'admin',
            firstName: 'Elsy',
            lastName: 'Castro',
            email: 'ce12006@localhost'
        ).save()
        Usuario vn10004 = new Usuario(
            username:'vn10004',
            password: 'admin',
            firstName: 'Alexis',
            lastName: 'Vásquez',
            email: 'vn10004@localhost'
        ).save()
        Rol user = new Rol(authority: 'ROLE_USER').save()
        Rol adminRole = new Rol(authority: 'ROLE_ADMIN').save()
        adminRole = adminRole!=null ? adminRole: Rol.findByAuthority("ROLE_ADMIN") 
        new Rol(authority: 'ROLE_CUSTOMER').save()
        UsuarioRol.create(admin,user)
        UsuarioRol.create(ab15002,adminRole)
        UsuarioRol.create(av12013,adminRole)
        UsuarioRol.create(cm13016,adminRole)
        UsuarioRol.create(ce12006,adminRole)
        UsuarioRol.create(vn10004,adminRole)

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
