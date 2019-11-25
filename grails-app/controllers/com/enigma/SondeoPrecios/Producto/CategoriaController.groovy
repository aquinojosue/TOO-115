package com.enigma.SondeoPrecios.Producto

class CategoriaController {

    def index() {
    	[categorias : Categoria.list()]
    }

    def create() {

    }
    def edit(){
    	[categoriaEdit : Categoria.get(params.id)]
    }
    def update(){
        try{
            def categoriaEdit = Categoria.get(params.id)
            categoriaEdit.properties = params
            categoriaEdit.save flush: true, failOnError: true
            flash.message = "Los cambios se han guardado correctamente."
            flash.typeMessage = "success"
        }
        catch(Exception e){
            flash.message = "Error, el error es " + e
            flash.typeMessage = "danger"
        }

        redirect(action: "index")
    }
    def save(){
    	def categoriaNueva = new Categoria(nombre:params.nombre)
    	try{
    		categoriaNueva.save flush: true, failOnError: true
            flash.message = "Categoría \'"+ categoriaNueva+"\' creada correctamente."
            flash.typeMessage = "success"
    	}
    	catch(Exception e){
            flash.message = "Error, el error es " + e
            flash.typeMessage = "danger"
    	}
        
        redirect(action: "index")
    }
    def delete(){
    	if(params.id != null){
		    def categoriaBorrar = Categoria.get(params.id)
    		if(params.confirmation != null){
                try {   
                    categoriaBorrar.delete flush: true, failOnError: true
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
    			[categoriaBorrar : categoriaBorrar]
    		}
    	}
    	else{
    		redirect(action:"index")
    	}
    }
}
