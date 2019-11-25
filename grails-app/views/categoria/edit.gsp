<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar categor&iacute;a</title>
</head>
<body>
    <h2 class="mb-4">Editar categor&iacute;a "${categoriaEdit}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
	            	<div class="form-group">
	            		<label for="exampleInputEmail1">Nombre de la categor&iacute;a</label>
	            			<g:textField class="form-control" name="nombre" placeholder="Ingrese su categoría aquí" value="${categoriaEdit}"/>
	            	</div>
                    <g:hiddenField name="id" value="${categoriaEdit.id}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
