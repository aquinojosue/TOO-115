<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Agregar precio</title>
</head>
<body>
    <h2 class="mb-4">Agregar Precio</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="save">
                    <div class="form-group">
                        <label for="descripcion">Mercado</label>
                        <g:select class="form-control" name="mercadoSelected" from="${mercados}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Producto</label>
                        <g:select class="form-control" name="productoSelected" from="${productos}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="nombre">Precio</label>
                            <g:textField class="form-control" name="precio" placeholder="Ingrese el precio del producto aquí"/>
                    </div>
	            	<button type="submit" class="btn btn-primary">Agregar precio</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
