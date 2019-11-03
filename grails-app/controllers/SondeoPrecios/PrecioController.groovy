package SondeoPrecios

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PrecioController {

    PrecioService precioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond precioService.list(params), model:[precioCount: precioService.count()]
    }

    def show(Long id) {
        respond precioService.get(id)
    }

    def create() {
        respond new Precio(params)
    }

    def save(Precio precio) {
        if (precio == null) {
            notFound()
            return
        }

        try {
            precioService.save(precio)
        } catch (ValidationException e) {
            respond precio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'precio.label', default: 'Precio'), precio.id])
                redirect precio
            }
            '*' { respond precio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond precioService.get(id)
    }

    def update(Precio precio) {
        if (precio == null) {
            notFound()
            return
        }

        try {
            precioService.save(precio)
        } catch (ValidationException e) {
            respond precio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'precio.label', default: 'Precio'), precio.id])
                redirect precio
            }
            '*'{ respond precio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        precioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'precio.label', default: 'Precio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'precio.label', default: 'Precio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
