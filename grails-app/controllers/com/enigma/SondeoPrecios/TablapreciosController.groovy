package com.enigma.SondeoPrecios 

import org.apache.poi.ss.usermodel.BorderStyle

import com.jameskleeh.excel.ExcelBuilder
import org.apache.poi.xssf.usermodel.XSSFWorkbook

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

        def headers = ["Categoría", "Producto", "Marca","Cantidad","Unidad"]

        datos.first().productos.first().mercados.each(){ mercado ->
            headers.add(mercado.mercado)
        }
        
        response.setContentType("application/vnd.ms-excel; charset=UTF-8")
        response.setHeader("Content-Disposition", "attachment; filename=reporte_precios_"+new Date().format( 'dd_MM_yyyy' )+".xlsx")

        ExcelBuilder.output(response.outputStream) {
            def hoja = sheet{
                row{
                    merge([alignment: "center", backgroundColor: "#244062", font: [bold: true, color: "#FFFFFF", size: 24], wrapped: true, border: BorderStyle.MEDIUM]){
                        cell("Sondeo de Precios")
                        skipCells(4+datos.first().productos.first().mercados.size())
                    }
                }
                row{
                    merge([alignment: "center", backgroundColor: "#385f8f", font: [bold: true, color: "#FFFFFF", name: "Times New Roman"], wrapped: true, border: BorderStyle.MEDIUM]){
                        cell("Fecha del reporte: "+new Date().format( 'dd/MM/yyyy' ))
                        skipCells(4)
                    }
                    merge([alignment: "center", backgroundColor: "#385f8f", font: [bold: true, color: "#FFFFFF", name: "Times New Roman"], wrapped: true, border: BorderStyle.MEDIUM]){
                        cell("Precios")
                        skipCells(datos.first().productos.first().mercados.size()-1)
                    }
                }
                row{
                    headers.each{ header->
                        cell(header,[alignment: "center", backgroundColor: "#4372ab", font: [bold: true, color: "#FFFFFF", name: "Times New Roman"], border: BorderStyle.MEDIUM])
                    }
                }
                datos.each{categoria ->
                    categoria.productos.each{producto ->                
                        row{
                            cell(categoria.categoria.nombre)
                            cell(producto.producto.nombre)
                            cell(producto.producto.marca)
                            cell(producto.producto.cantidad)
                            cell(producto.producto.unidadMedida.nombre)
                            producto.mercados.each{ mercado ->
                                cell(mercado.precio,[alignment: 'center'])
                            }
                        }
                    }
                }
            }
            int numero = hoja.getRow(2).getPhysicalNumberOfCells()
            while(numero>=0){
                hoja.autoSizeColumn(numero--)
            }
        }
    }
}
