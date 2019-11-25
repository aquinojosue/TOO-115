package com.enigma.SondeoPrecios.Producto

import grails.gorm.transactions.Transactional
import com.enigma.SondeoPrecios.Ubicacion.*
import com.enigma.SondeoPrecios.Producto.*
@Transactional
class PrecioService {

    def serviceMethod() {

    }
    
    def productoPrecios(Producto producto){
    	def datos = []
    	def mercados = Mercado.list()
    	mercados.each { mercado ->
    		def precios = Precio.findAllByMercadoAndProducto(
    			mercado,
    			producto,
    			[sort:'dateCreated',order:'desc']
    		)
    		if(!precios.isEmpty()){
    			def precio = precios.first()
    			def row = [mercado : precio.mercado, producto : precio.producto, precio: precio]
    			datos.add(row)
    		}
    	}
    	return datos
    }

   
    def busqueda(Mercado mercadoSelected, Categoria categoriaSelected){
        def listaCategorias = categoriaSelected? [categoriaSelected]: Categoria.list()
        def listaMercados = mercadoSelected? [mercadoSelected]: Mercado.list()

        def datos = []

        listaCategorias.each{ categoria ->
            def categoryData = []
            categoria.productos.each{ producto ->
                def productData = []
                def promedio = []
                listaMercados.each{ mercado ->
                    def precios = Precio.findAllByMercadoAndProducto(
                        mercado,
                        producto,
                        [sort:'dateCreated', order: 'desc']
                    )
                    def precio = precios.isEmpty()? "--": precios.first().precio
                    if(!precios.isEmpty())
                        promedio.add(precios.first().precio)
                    def marketRow = [mercado: mercado, precio: precio]
                    productData.add(marketRow)
                }
                promedio = promedio.isEmpty()? [0]: promedio
                def productRow = [producto: producto, mercados: productData, promedio: (promedio.sum()/promedio.size())]
                categoryData.add(productRow)
            }
            def categoryRow = [categoria: categoria, productos: categoryData]
            datos.add(categoryRow)
        }
        return datos
    }
}
