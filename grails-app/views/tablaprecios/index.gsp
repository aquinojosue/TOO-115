<!doctype html>
<%@ page import="com.enigma.SondeoPrecios.Ubicacion.*" %>
<%@ page import="com.enigma.SondeoPrecios.Producto.*" %>
<html>
<head>
    <meta name="layout" content="home"/>
    <title>Tabla de precios</title>
</head>
<body>
    <main class="page shopping-cart-page">
        <section class="clean-block clean-cart dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Tabla de precios</h2>
                    <g:link action="reporte" class="btn btn-secondary">Descargar reporte de precios</g:link>
                </div>

                <div class="content">
                    <div class="card bg-light mb-3">
                        <div class="card-header">Parámetros de búsqueda</div>
                        <div class="card-body">
                            <g:form name="busquedaTabla" action="index">
                                <div class="row">
                                    <div class="form-group col">
                                        <label for="categoriaSelected">Categoría:</label>
                                        <g:select class="form-control" optionKey="id" optionValue="nombre" name="categoriaSelected" from="${Categoria.list()}" noSelection="${['null':'Todas las categorías']}" value="${categoriaSelected}"/>
                                    </div>
                                    <div class="form-group col">
                                        <label for="mercadoSelected">Mercado</label>
                                        <g:select class="form-control" optionKey="id" optionValue="nombre" name="mercadoSelected" from="${Mercado.list()}" value="${mercadoSelected}" noSelection="${['null':'Todos los mercados']}"/>
                                    </div>
                                </div>
                                <g:submitButton class="btn btn-primary" name="Realizar búsqueda"/>
                            </g:form>
                        </div>
                    </div>
                </div>

                <div class="content">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Categoría</th>
                                    <th>Producto</th>
                                    <th>Unidad de medida</th>
                                    <g:each in="${datos.first().productos.first().mercados}" var="mercado">
                                        <th>${mercado.mercado}</th>
                                    </g:each>
                                    <th>Promedio nacional</th>
                                </tr>
                            </thead>
                            <tbody>
                                <g:each in="${datos}" var="categoria">
                                    <g:each in="${categoria.productos}" var="producto">
                                        <tr>
                                            <td>${categoria.categoria}</td>
                                            <td>${producto.producto}</td>
                                            <td>${producto.producto.unidadMedida}</td>
                                            <g:each in="${producto.mercados}" var="mercado">
                                                <td>${mercado.precio}</td>
                                            </g:each>
                                            <td>
                                                <g:formatNumber number="${producto.promedio}" type="number" minFractionDigits="2" maxFractionDigits="2" />
                                            </td>
                                        </tr>
                                    </g:each>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>
