<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Agregar rol</title>
</head>
<body>
    <h2 class="mb-4">Agregar rol</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
                    <div class="form-group">
                        <label for="nombre">Nombre del rol</label>
                        <g:textField class="form-control" name="authority" placeholder="Ingrese el nombre aquí"/>
                    </div>
	            	<button type="submit" class="btn btn-primary">Agregar rol</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
