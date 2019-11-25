<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar municipio</title>
</head>
<body>
    <h2 class="mb-4">Editar municipio "${editElement}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
            <div class="col-lg-4">
                <g:form action="update">
                    <div class="form-group">
                        <label for="nombre">Nombre del municipio</label>
                            <g:textField class="form-control" name="nombre" placeholder="Ingrese su municipio aquí" value="${editElement}"/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Departamento</label>
                        <g:select class="form-control" name="departamentoSelected" from="${departamentos}" value="${editElement.departamento.id}"optionKey="id" />
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
                    <button type="submit" class="btn btn-primary">Guardar cambios</button>
                </g:form>
            </div>
        </div>
    </div>
</body>
</html>
