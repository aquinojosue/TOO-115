package sondeoprecios

class HomeController {

    def index() {
        if(isLoggedIn()){
            redirect(controller:'admin')
        }
    }
}
