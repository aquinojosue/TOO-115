<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar permisos de "${controllerPermiso.nombre}"</title>
</head>
<body>
    <h2 class="mb-4">Editar permisos de "${controllerPermiso.nombre}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
	            	<div class="form-group">
	            		<label>Roles que tienen acceso a ${controllerPermiso.nombre}</label>
                        <ul class="list-unstyled">
                            <g:each in="${controllerPermiso.rolConPermiso}" var="rol">
                                <li>
                                    <g:checkBox name="rolPermitido" value="${rol.rol}" checked="${rol.permitido}" />
                                    <label for="rolPermitido">${rol.rol}</label>
                                </li>
                            </g:each>
                        </ul>
	            	</div>
                    <g:hiddenField name="id" value="${controllerPermiso.nombre}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
