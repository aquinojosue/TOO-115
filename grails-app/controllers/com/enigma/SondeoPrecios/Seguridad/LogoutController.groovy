package com.enigma.SondeoPrecios.Seguridad

class LogoutController {

    def index() { 
    	session.invalidate()
    	redirect(uri:"/")
    }
}
