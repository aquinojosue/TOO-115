<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Crear unidad de medida</title>
</head>
<body>
    <h2 class="mb-4">Crear unidad de medida</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
	            	<div class="form-group">
	            		<label for="nombre">Nombre</label>
	            			<g:textField class="form-control" name="nombre" placeholder="Ingrese el nombre aquí"/>
	            	</div>
                    <div class="form-group">
                        <label for="descripcion">Representación</label>
                        <g:textField class="form-control" name="representacion" placeholder="Representación de la unidad de medida"/>
                    </div>
	            	  <button type="submit" class="btn btn-primary">Crear Unidad de Medida</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
