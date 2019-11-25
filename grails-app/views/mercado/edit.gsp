<!doctype html>
<%@ page import="com.enigma.SondeoPrecios.Ubicacion.*" %>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Modificar mercado</title>
</head>
<body>
    <h2 class="mb-4">Modificar mercado "${editElement}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
            <div class="col-lg-4">
                <g:form action="update">
                    <div class="form-group">
                        <label for="nombre">Nombre del establecimiento</label>
                            <g:textField class="form-control" name="nombre" placeholder="Ingrese el nombre del establecimiento aquí" value="${editElement.nombre}"/>
                    </div>
                    <div class="form-group">
                        <label for="direccion">Dirección</label>
                            <g:textField class="form-control" name="direccion" placeholder="Ingrese la dirección aquí" value="${editElement.direccion}"/>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono</label>
                            <g:textField class="form-control" name="telefono" placeholder="Ingrese el teléfono aquí" value="${editElement.telefono}"/>
                    </div>
                    <div class="form-group">
                        <label for="municipioSelected">Municipio</label>
                        <g:select class="form-control" name="municipioSelected" from="${Municipio.list()}" optionKey="id" value="${editElement.municipio.id}"/>
                    </div>
                    <div class="form-group">
                        <label for="tipoMercadoSelected">Tipo de Mercado</label>
                        <g:select class="form-control" name="tipoMercadoSelected" from="${TipoMercado.list()}" optionKey="id" value="${editElement.tipoMercado.id}" />
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
                    <button type="submit" class="btn btn-primary">Guardar cambios</button>
                </g:form>
            </div>
        </div>
    </div>
</body>
</html>
