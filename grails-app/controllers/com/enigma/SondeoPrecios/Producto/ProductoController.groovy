package com.enigma.SondeoPrecios.Producto

class ProductoController {

    def index() { 
    	[productos : Producto.list()]
    }
    def create(){
    	[
	    	categorias: Categoria.list(),
	    	marcas: Marca.list(),
	    	presentaciones: Presentacion.list(),
	    	unidades: UnidadMedida.list()
	    ]
    }
    def save(){
    	def categoria = Categoria.get(params.categoriaSelected)
    	def marca = Marca.get(params.marcaSelected)
    	def presentacion = Presentacion.get(params.presentacionSelected)
    	def unidadMedida = UnidadMedida.get(params.uniadSelected)

    	def productoNuevo = new Producto(
    		nombre: params.nombre,
    		cantidad: params.cantidad,
    		categoria: categoria,
    		marca: marca,
    		presentacion: presentacion,
    		unidadMedida: unidadMedida
    	)
    	try{
    		productoNuevo.save flush: true, failOnError: true
    		flash.message = "Producto \'"+ productoNuevo.nombre+"\' creado correctamente."
	    	flash.typeMessage = "success"
        	redirect(action: "index")
    	}
    	catch(Exception e){
    		flash.message = "Error, el error es " + e
	    	flash.typeMessage = "danger"
	        redirect(action: "index")
    	}
    }
    def edit(){
    	[
    		editElement : Producto.get(params.id),
	    	categorias: Categoria.list(),
	    	marcas: Marca.list(),
	    	presentaciones: Presentacion.list(),
	    	unidades: UnidadMedida.list()
	    ]
    }
    def update(){
    	def categoria = Categoria.get(params.categoriaSelected)
    	def marca = Marca.get(params.marcaSelected)
    	def presentacion = Presentacion.get(params.presentacionSelected)
    	def unidadMedida = UnidadMedida.get(params.uniadSelected)
    	try{
	    	def editElement = Producto.get(params.id)
	    	editElement.nombre = params.nombre
	    	editElement.cantidad = params.cantidad.toInteger()
	    	editElement.categoria = categoria
	    	editElement.marca = marca
	    	editElement.presentacion = presentacion
	    	editElement.unidadMedida = unidadMedida

	    	editElement.save flush: true, failOnError: true
	    	flash.message = "Los cambios se guardaron con éxito."
	    	flash.typeMessage = "success"
	        redirect(action: "index")
    	}
    	catch(Exception e){
    		flash.message = "Error, el error es " + e
	    	flash.typeMessage = "danger"
	        redirect(action: "index")
    	}
    }
    def delete(){
    	if(params.id != null){
		    def deleteElement = Producto.get(params.id)
    		if(params.confirmation != null){
                try {   
                    deleteElement.delete flush: true, failOnError: true
                    flash.message = "Los cambios se han guardado correctamente."
                    flash.typeMessage = "success"
                }
                catch(Exception e){
                    flash.message = "Error, el error es " + e
                    flash.typeMessage = "danger"
                }
		    	redirect(action:"index")
    		}
    		else {
    			[deleteElement : deleteElement]
    		}
    	}
    	else{
    		redirect(action:"index")
    	}
    }
}
