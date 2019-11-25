package com.enigma.SondeoPrecios.Seguridad

import grails.gorm.transactions.Transactional
import org.springframework.beans.BeanWrapper
import org.springframework.beans.PropertyAccessorFactory
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

@Transactional
class ControllerService {
	def grailsApplication
    MessageSource messageSource


    def serviceMethod() {		
    	def data = []
		for (controller in grailsApplication.controllerClasses) {
			def controllerInfo = [:]
			controllerInfo.controller = controller.logicalPropertyName
			controllerInfo.controllerName = controller.fullName
			List actions = []
			BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(controller.newInstance())
			for (pd in beanWrapper.propertyDescriptors) {
				String closureClassName = controller.getPropertyOrStaticPropertyOrFieldValue(pd.name, Closure)?.class?.name
				if (closureClassName) actions << pd.name
			}
			controllerInfo.actions = actions.sort()
			data << controllerInfo
		}
		return data
    }

    def conPermiso(){
    	String filtro = "login, logout, admin, home, tablaprecios" //Filtro para no poner los siguientes controllers en la lista
		def data = []
		serviceMethod().each{ controlador ->
			if(!filtro.split(", ").contains(controlador.controller)){ //Si el controller está en la lista del filtro, este se omite
				String uri = "/"+controlador.controller+"/**"
				def rolesPermitidos = Requestmap.findByUrl(uri)?.configAttribute
				def rolConPermiso = []
				Rol.list().each{ rol ->
					def rolPermitido = rolesPermitidos.contains(rol.authority)
					rolConPermiso.add([rol: rol.authority, permitido: rolPermitido])
				}
				//def row = [nombre: controlador.controller, rolConPermiso: rolConPermiso]
				def label = messageSource.getMessage('controller.label.'+controlador.controller,null, 'Default Message', LocaleContextHolder.locale)
 
				def row = [nombre: controlador.controller, label: label, rolConPermiso: rolConPermiso]
				data.add(row)
			}
		}
		return data
    }

    def controllerPermiso(def controller){
    	String uri = "/"+controller+"/**"
    	def rolesPermitidos = Requestmap.findByUrl(uri)?.configAttribute
		def rolConPermiso = []
		Rol.list().each{ rol ->
			def rolPermitido = rolesPermitidos.contains(rol.authority)
			rolConPermiso.add([rol: rol.authority, permitido: rolPermitido])
		}
		return [nombre: controller, rolConPermiso: rolConPermiso]
    }

    def checkPermissions(String controllers, Usuario checkedUser){
    	def found = false
    	controllers.split(",").each{ controller ->
    		String control = controller.replaceAll("\\s","") //Linea para poder borrar los espacios que se puedan encontrar
    		String uri = "/"+control+"/**"
    		def configAttribute = Requestmap.findByUrl(uri)?.configAttribute
    		UsuarioRol.findAllByUsuario(checkedUser).each{ userRole ->
    			found = configAttribute?.contains(userRole.rol.authority)? true: found
    		}
    	}
    	return found
    }
}
