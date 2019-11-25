<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Categor&iacute;as</title>
</head>
<body>
    <h2 class="mb-4">Categor&iacute;as</h2>
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
            <g:link action="create"><i class="fa fa-fw fa-plus"></i>Crear categor&iacute;a</g:link>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col" style="width:85%">Nombre</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${categorias}" var="categoria">
                        <tr>
                            <td>${categoria}</td>
                            <td>
                                <ul class="list-unstyled">
                                    <li>
                                        <g:link action="edit" id="${categoria.id}"><i class="fa fa-fw fa-edit"></i>Editar</g:link>
                                    </li>
                                    <li>
                                        <g:link action="delete" id="${categoria.id}"><i class="fa fa-fw fa-trash"></i>Eliminar</g:link>
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
