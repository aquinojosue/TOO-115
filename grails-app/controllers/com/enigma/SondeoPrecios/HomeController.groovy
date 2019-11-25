package com.enigma.SondeoPrecios
import com.enigma.SondeoPrecios.Ubicacion.Mercado

class HomeController {
	def precioService

    def index() { 
        if(isLoggedIn()){
            redirect(controller: 'admin')
        }
    }
    def tablaPrecios(){
    	[datos: precioService.getTable(), mercados: Mercado.list()]
    }
}
