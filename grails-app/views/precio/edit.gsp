<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar precio</title>
</head>
<body>
    <h2 class="mb-4">Editar Precio</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
            <div class="col-lg-4">
                <g:form action="update">
                    <div class="form-group">
                        <label for="descripcion">Mercado</label>
                        <g:select class="form-control" name="mercadoSelected" from="${mercados}" optionKey="id" value="${editElement.mercado.id}"/>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Producto</label>
                        <g:select class="form-control" name="productoSelected" from="${productos}" optionKey="id" value="${editElement.producto.id}" />
                    </div>
                    <div class="form-group">
                        <label for="nombre">Precio</label>
                            <g:textField class="form-control" name="precio" placeholder="Ingrese el precio del producto aquí" value="${editElement.precio}"/>
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
                    <button type="submit" class="btn btn-primary">Guardar cambios</button>
                </g:form>
            </div>
        </div>
    </div>
</body>
</html>
