package sondeoprecios
import SondeoPrecios.*

class PruebaController {

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

        UsuarioRol.remove usuario, rolAnterior
        UsuarioRol.create usuario, rolNuevo

        UsuarioRol.withSession {
            it.flush()
            it.clear()
        }

        redirect(action: "index")
    }
}
