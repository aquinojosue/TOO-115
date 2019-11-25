<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Crear municipio</title>
</head>
<body>
    <h2 class="mb-4">Crear municipio</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
	            	<div class="form-group">
	            		<label for="nombre">Nombre del municipio</label>
	            			<g:textField class="form-control" name="nombre" placeholder="Ingrese el nombre del municipio aquí"/>
	            	</div>
                    <div class="form-group">
                        <label for="descripcion">Departamento</label>
                        <g:select class="form-control" name="departamentoSelected" from="${departamentos}" optionKey="id" />
                    </div>
	            	  <button type="submit" class="btn btn-primary">Crear Municipio</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
