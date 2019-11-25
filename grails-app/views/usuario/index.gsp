<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Usuarios</title>
</head>
<body>
    <h2 class="mb-4">Usuarios</h2>
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
            <g:link action="create"><i class="fa fa-fw fa-plus"></i>Crear usuario</g:link>
            <table class="table table-hover">
                <thead >
                    <tr>
                        <th scope="col" style="width:15%">Username</th>
                        <th scope="col" style="width:25%">Nombres</th>
                        <th scope="col" style="width:20%">Apellidos</th>
                        <th scope="col" style="width:25%">Roles</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${usuarios}" var="usuario">
                        <tr>
                            <td>${usuario.username}</td>
                            <td>${usuario.firstName}</td>
                            <td>${usuario.lastName}</td>
                            <td>
                                <ul>
                                    <g:each in="${usuario.getAuthorities()}" var="rol">
                                        <li>${rol.authority}</li>
                                    </g:each>
                                </ul>
                            </td>
                            <td>
                                <ul class="list-unstyled">
                                    <li>
                                        <g:link action="edit" id="${usuario.id}"><i class="fa fa-fw fa-edit"></i>Editar</g:link>
                                    </li>
                                    <li>
                                        <g:link action="delete" id="${usuario.id}"><i class="fa fa-fw fa-trash"></i>Eliminar</g:link>
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
