package com.enigma.SondeoPrecios 

import pl.touk.excel.export.WebXlsxExporter
import pl.touk.excel.export.XlsxExporter
import pl.touk.excel.export.getters.LongToDatePropertyGetter
import pl.touk.excel.export.getters.MessageFromPropertyGetter

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

    def reporte(){
        def datos =  precioService.busqueda(null, null)
        if(!Producto.list() || !Mercado.list() || !Categoria.list()){
            render(view:'error')
            return
        }

        def headers = ['Categoría', 'Producto', 'Unidad de medida']

        datos.first().productos.first().mercados.each(){ mercado ->
            headers.add(mercado.mercado)
        }
        headers.add('Promedio nacional')

        new WebXlsxExporter().with {
            setResponseHeaders(response)
            fillHeader(headers)
            def i=0
            datos.each{categoria ->
                categoria.productos.each{producto ->                
                    def row = []
                    row.add(categoria.categoria)
                    row.add(producto.producto)
                    row.add(producto.producto.unidadMedida)
                    producto.mercados.each{ mercado ->
                        row.add(mercado.precio)
                    }
                    row.add(producto.promedio)
                    fillRow(row, ++i)
                }
            }
            save(response.outputStream)
        }
    }
}
