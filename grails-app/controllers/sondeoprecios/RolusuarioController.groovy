package sondeoprecios
import SondeoPrecios.*

class RolusuarioController {

    def index(){
        def userRoles = UsuarioRol.list()
        [userRoles:userRoles]
    }

    def edit(){
        def usuario = Usuario.get(params.id)
        [roles:Rol.list(), usuario:usuario, selected:UsuarioRol.findByUsuario(usuario).rol, userID:params.id]
    }

    def save(){
        def usuario = Usuario.get(params.userID)
        def rolAnterior = UsuarioRol.findByUsuario(usuario).rol
        def rolNuevo = Rol.findByAuthority(params.chosenRole)

        if (!UsuarioRol.exists(usuario.id, rolNuevo.id)) {
            UsuarioRol.remove usuario, rolAnterior
            UsuarioRol.withSession {
                it.flush()
                it.clear()
            }

            UsuarioRol.create usuario, rolNuevo
            if (!usuario.hasErrors() && usuario.merge(flush: true)) {
                applicationContext.springSecurityService.reauthenticate usuario.username
            }
        }
        redirect(action: "index")
    }
}
