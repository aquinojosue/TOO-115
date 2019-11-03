<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="tabla" />
        <title>Tabla de precios</title>
    </head>
    <body>
        <sec:ifLoggedIn>
            Logged in as <sec:username/>
        </sec:ifLoggedIn>
    	<h1>Tabla de precios</h1>
    	<table class="table">
    		<thead class="thead-dark">
    			<tr>
    				<th>Categor&iacute;a</th>
    				<th>Ubicaci&oacute;n</th>
    				<th>Marca</th>
    				<th>Producto</th>
    				<th>Presentaci&oacute;n</th>
    				<th>Cantidad</th>
    				<th>Unidad de Medida</th>
    				<th>Precio</th>
    			</tr>
    		</thead>
    		<tbody>
    			<g:each  in="${datos}">
    				<tr>
    					<td>${it.producto.categoria}</td>
    					<td>${it.ubicacion}</td>
    					<td>${it.producto.marca}</td>
    					<td>${it.producto.nombre}</td>
    					<td>${it.producto.presentacion}</td>
    					<td>${it.producto.cantidad}</td>
    					<td>${it.producto.unidadMedida}</td>
    					<td>${it.precio}</td>
    				</tr>
    			</g:each>
    		</tbody>
    	</table>
    </body>
</html>