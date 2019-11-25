<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Productos</title>
</head>
<body>
    <h2 class="mb-4">Productos</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:if test="${flash.message}">
            <div class="alert alert-${flash.typeMessage} alert-dismissible message" role="alert status">
                ${flash.message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            </g:if>
            <g:link action="create"><i class="fa fa-fw fa-plus"></i>Crear producto</g:link>
            <table class="table table-hover">
                <thead >
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Categoría</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Presentación</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Unidad de Medida</th>
                        <th scope="col">Precios</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${productos}">
                        <tr>
                            <td>${it.nombre}</td>
                            <td>${it.categoria}</td>
                            <td>${it.marca}</td>
                            <td>${it.presentacion}</td>
                            <td>${it.cantidad}</td>
                            <td>${it.unidadMedida}</td>
                            <td>
                                <g:set var="precios" bean="precioService"/>
                                <ul>
                                    <g:each in="${precios.productoPrecios(it)}" var="precio">
                                        <li>$ ${precio.precio} en ${precio.mercado}</li>
                                    </g:each>
                                </ul>
                            </td>
                            <td>
                                <ul class="list-unstyled">
                                    <li>
                                        <g:link action="edit" id="${it.id}"><i class="fa fa-fw fa-edit"></i>Editar</g:link>
                                    </li>
                                    <li>
                                        <g:link action="delete" id="${it.id}"><i class="fa fa-fw fa-trash"></i>Eliminar</g:link>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
