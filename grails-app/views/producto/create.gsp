<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Agregar Producto</title>
</head>
<body>
    <h2 class="mb-4">Agregar Producto</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
	            	<div class="form-group">
	            		<label for="nombre">Nombre</label>
	            			<g:textField class="form-control" name="nombre" placeholder="Ingrese el nombre del producto aquí"/>
	            	</div>
                    <div class="form-group">
                        <label for="nombre">Cantidad</label>
                            <g:textField class="form-control" name="cantidad" placeholder="Ingrese la cantidad aquí"/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Categoría</label>
                        <g:select class="form-control" name="categoriaSelected" from="${categorias}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Marca</label>
                        <g:select class="form-control" name="marcaSelected" from="${marcas}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Presentación</label>
                        <g:select class="form-control" name="presentacionSelected" from="${presentaciones}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Unidad de Medida</label>
                        <g:select class="form-control" name="uniadSelected" from="${unidades}" optionKey="id" />
                    </div>
	            	<button type="submit" class="btn btn-primary">Agregar Producto</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
