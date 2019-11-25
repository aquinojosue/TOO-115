<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar rol</title>
</head>
<body>
    <h2 class="mb-4">Editar rol "${editElement.authority}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
                    <div class="form-group">
                        <label for="nombre">Nombre del rol</label>
                        <g:textField class="form-control" name="authority" placeholder="Ingrese el nombre aquí" value="${editElement.authority}" />
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
