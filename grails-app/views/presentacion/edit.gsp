<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar presentación</title>
</head>
<body>
    <h2 class="mb-4">Editar presentación "${editElement}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
	            	<div class="form-group">
	            		<label for="nombre">Nombre</label>
	            		<g:textField class="form-control" name="nombre" placeholder="Ingrese el nombre de la presentación aquí" value="${editElement}"/>
	            	</div>
                    <g:hiddenField name="id" value="${editElement.id}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
