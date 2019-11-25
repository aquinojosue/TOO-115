<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Eliminar categor&iacute;a</title>
</head>
<body>
    <h2 class="mb-4">¿Está seguro?</h2>
    <div class="card mb-4">
        <div class="card-body">
            ¿Está seguro que desea eliminar la categoria "${categoriaBorrar}"?
            <br>
            <g:link action="index" class="btn btn-secondary">Cancelar</g:link> <g:link action="delete" id="${categoriaBorrar.id}" params="[confirmation: 'true']" class="btn btn-primary">Eliminar Categor&iacute;a</g:link>
        </div>
    </div>
</body>
</html>
