<!doctype html>
<%@ page import="com.enigma.SondeoPrecios.Ubicacion.*" %>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Mercados</title>
</head>
<body>
    <h2 class="mb-4">Mercados</h2>
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
            <g:link action="create"><i class="fa fa-fw fa-plus"></i>Crear mercado</g:link>
            <table class="table table-hover">
                <thead >
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Tipo de Mercado</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Municipio</th>
                        <th scope="col">Departamento</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Acci&oacute;n</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${Mercado.list()}">
                        <tr>
                            <td>${it}</td>
                            <td>${it.tipoMercado}</td>
                            <td>${it.direccion}</td>
                            <td>${it.municipio}</td>
                            <td>${it.municipio.departamento}</td>
                            <td>${it.telefono}</td>
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
