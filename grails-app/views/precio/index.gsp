<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Precios</title>
</head>
<body>
    <h2 class="mb-4">Precios</h2>
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
            <g:link action="create"><i class="fa fa-fw fa-plus"></i>Agregar precio</g:link>
            <g:link controller="tablaprecios" action="reporte"><i class="fa fa-fw fa-download"></i>Descargar reporte de precios</g:link>
            <table class="table table-hover">
                <thead >
                    <tr>
                        <th scope="col">Fecha de creación</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Ubicación</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${precios}">
                        <tr>
                            <td><g:formatDate format="EEEE dd/MM/yyyy HH:mm:ss" date="${it.dateCreated}"/></td>
                            <td>${it.producto}</td>
                            <td>${it.mercado}</td>
                            <td>${it}</td>
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
