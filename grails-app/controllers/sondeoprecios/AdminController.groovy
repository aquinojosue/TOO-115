package sondeoprecios
import sondeoprecios.*

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class AdminController {

    def index() { 
    	def user = applicationContext.springSecurityService.currentUser
    	[user:user.username]
    }
}
