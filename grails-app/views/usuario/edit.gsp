<!doctype html>
<html>
<head>
    <meta name="layout" content="admin"/>
    <title>Editar usuario</title>
</head>
<body>
    <h2 class="mb-4">Editar usuario "${editElement}"</h2>
    <div class="card mb-4">
        <div class="card-body">
            <g:link action="index"><i class="fa fa-fw fa-home"></i>Inicio</g:link><hr>
        	<div class="col-lg-4">
	            <g:form action="update">
                    <div class="form-group">
                        <label for="nombre">Nombre del usuario</label>
                        <g:textField class="form-control" name="username" placeholder="Ingrese el nombre aquí" value="${editElement.username}"/>
                    </div>
	            	<div class="form-group">
	            		<label for="nombre">Nombres</label>
	            		<g:textField class="form-control" name="firstName" placeholder="Ingrese los nombres aquí" value="${editElement.firstName}"/>
	            	</div>
                    <div class="form-group">
                        <label for="nombre">Apellidos</label>
                        <g:textField class="form-control" name="lastName" placeholder="Ingrese los apellidos aquí" value="${editElement.lastName}"/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Correo electrónico</label>
                        <g:textField class="form-control" name="email" placeholder="Ingrese los apellidos aquí" value="${editElement.email}"/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Contraseña</label>
                        <g:passwordField class="form-control" name="password"/>
                    </div>
                    <div class="form-group">
                        <label>Roles asignados</label>
                        <ul class="list-unstyled">
                            <g:each in="${listaRoles}" var="rol">
                                <li>
                                    <g:checkBox name="rolAsignado" id="${rol.authority}" value="${rol.authority}" checked="${rol.found}" />
                                    <label for="${rol.authority}">${rol.authority}</label>
                                </li>
                            </g:each>
                        </ul>
                    </div>
                    <g:hiddenField name="id" value="${editElement.id}" />
	            	<button type="submit" class="btn btn-primary">Guardar cambios</button>
	            </g:form>
	        </div>
        </div>
    </div>
</body>
</html>
