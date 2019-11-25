<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Crear marca</title>
</head>
<body>
    <h2 class="mb-4">Crear marca</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
	            	<div class="form-group">
	            		<label for="nombre">Nombre de la marca</label>
	            			<g:textField class="form-control" name="nombre" placeholder="Ingrese su marca aquí"/>
	            	</div>
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <g:textArea class="form-control" name="descripcion" placeholder="Descripción de la marca" rows="5" cols="40"/>
                    </div>
	            	  <button type="submit" class="btn btn-primary">Crear Marca</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
