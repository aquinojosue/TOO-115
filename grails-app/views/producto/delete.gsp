<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Borrar producto</title>
</head>
<body>
    <h2 class="mb-4">¿Está seguro?</h2>
    <div class="card mb-4">
        <div class="card-body">
            ¿Está seguro que desea eliminar el Producto "${deleteElement}"?
            <br>
            <g:link action="index" class="btn btn-secondary">Cancelar</g:link> <g:link action="delete" id="${deleteElement.id}" params="[confirmation: 'true']" class="btn btn-primary">Eliminar Producto</g:link>
        </div>
    </div>
</body>
</html>
