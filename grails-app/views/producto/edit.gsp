<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Modificar Producto</title>
</head>
<body>
    <h2 class="mb-4">Modificar Producto</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
            <div class="col-lg-4">
                <g:form action="update">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <g:textField class="form-control" name="nombre" value="${editElement.nombre}" placeholder="Ingrese el nombre del producto aquí"/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Cantidad</label>
                        <g:textField class="form-control" name="cantidad" value="${editElement.cantidad}" placeholder="Ingrese la cantidad aquí"/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Categoría</label>
                        <g:select class="form-control" name="categoriaSelected" value="${editElement.categoria.id}" from="${categorias}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Marca</label>
                        <g:select class="form-control" name="marcaSelected" value="${editElement.marca.id}" from="${marcas}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Presentación</label>
                        <g:select class="form-control" name="presentacionSelected" value="${editElement.presentacion.id}" from="${presentaciones}" optionKey="id" />
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Unidad de Medida</label>
                        <g:select class="form-control" name="uniadSelected" value="${editElement.unidadMedida.id}" from="${unidades}" optionKey="id" />
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
                    <button type="submit" class="btn btn-primary">Agregar Producto</button>
                </g:form>
            </div>
        </div>
    </div>
</body>
</html>
