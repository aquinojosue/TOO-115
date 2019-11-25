<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar marca</title>
</head>
<body>
    <h2 class="mb-4">Editar marca "${editElement}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
	            	<div class="form-group">
	            		<label for="nombre">Nombre de la marca</label>
	            		<g:textField class="form-control" name="nombre" placeholder="Ingrese su marca aquí" value="${editElement}"/>
	            	</div>
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <g:textArea class="form-control" name="descripcion" placeholder="Descripción de la marca" rows="5" cols="40" value="${editElement.descripcion}"/>
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
