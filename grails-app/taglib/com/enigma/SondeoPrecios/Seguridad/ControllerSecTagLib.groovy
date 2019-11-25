package com.enigma.SondeoPrecios.Seguridad

class ControllerSecTagLib {
	def controllerService
	def springSecurityService
	
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def securedElement = { attrs, body ->
    	
    	def user = springSecurityService.currentUser
    	def controllerCheck = attrs.controllerCheck
    	if(controllerService.checkPermissions(controllerCheck,user))
    		out << render(template: "/shared/elementTemplate", model: [controllerDestino: controllerCheck, faIcon: attrs.faIcon, elementLabel: attrs.elementLabel])
    }

    def securedGroup = { attrs, body ->
    	def user = springSecurityService.currentUser
    	def controllerCheck = attrs.controllerCheck
    	if(controllerService.checkPermissions(controllerCheck,user)){
    		out << body()
    	}
    }
}
