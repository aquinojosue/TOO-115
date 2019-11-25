package com.enigma.SondeoPrecios.Seguridad

class PermisoController {
    def controllerService
    def springSecurityService

    def index() {
    	[listaPermisos: controllerService.conPermiso()]
    }
    def edit(){
    	[controllerPermiso: controllerService.controllerPermiso(params.id)]
    }
    def update(){
    	def rolesPermitidos = params.list('rolPermitido').join(", ")
    	String uri = "/"+params.id+"/**"
    	def requestmap = Requestmap.findByUrl(uri)
    	requestmap?.configAttribute = rolesPermitidos
    	requestmap.save flush: true, failOnError: true
    	springSecurityService.clearCachedRequestmaps()

	    redirect(action: "index")
    }
}
