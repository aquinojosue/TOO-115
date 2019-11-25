package com.enigma.SondeoPrecios
import com.enigma.SondeoPrecios.Ubicacion.Mercado
import com.enigma.SondeoPrecios.Producto.*

class TablapreciosController {
	def precioService

    def index() {
    	def categoriaSelected = Categoria.get(params.categoriaSelected)
    	def mercadoSelected = Mercado.get(params.mercadoSelected)

    	if(!Producto.list() || !Mercado.list() || !Categoria.list() || (categoriaSelected && categoriaSelected?.productos.isEmpty())){
    		render(view:'error')
    		return
    	}
    	[datos: precioService.busqueda(mercadoSelected, categoriaSelected),
    		categoriaSelected: categoriaSelected?.id,
    		mercadoSelected: mercadoSelected?.id]
    }

}
