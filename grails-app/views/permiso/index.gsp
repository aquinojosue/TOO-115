<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Permisos</title>
</head>
<body>
    <h2 class="mb-4">Permisos</h2>
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
            <table class="table table-hover">
                <thead >
                    <tr>
                        <th scope="col" style="width:35%">Página</th>
                        <th scope="col" style="width:50%">Roles que tienen acceso</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${listaPermisos}" var="controller">
                        <tr>
                            <td>${controller.label}</td>
                            <td>
                                <ul>
                                    <g:each in="${controller.rolConPermiso}" var="rol">
                                        <g:if test="${rol.permitido}"><li>${rol.rol}</li></g:if>
                                    </g:each>
                                </ul>
                            </td>
                            <td>
                                <ul class="list-unstyled">
                                    <li>
                                        <g:link action="edit" id="${controller.nombre}"><i class="fa fa-fw fa-edit"></i>Editar</g:link>
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
