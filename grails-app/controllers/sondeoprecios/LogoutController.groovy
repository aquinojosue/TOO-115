package sondeoprecios

class LogoutController {

    def index() { 
    	session.invalidate()
    	redirect(uri:"/")
    }
}
