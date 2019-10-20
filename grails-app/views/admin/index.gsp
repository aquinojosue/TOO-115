<!DOCTYPE html>
<html lang="en" class="no-js">
  <head>
        <meta name="layout" content="main" />
        <title>Panel de administracion - ${applicationContext.springSecurityService.currentUser.username}</title>
</head>
  <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/admin')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
            <div class="content" role="main">
                <h1>Bienvenido, ${applicationContext.springSecurityService.currentUser.username}</h1>
                <section class="row colset-2-its">

                    <div class="col-md-2">
                        <h2>Control de Usuarios</h2>
                        <ul>
                            <li><a href="${createLink(controller:'usuario')}">Lista de Usuarios</a></li>
                            <li><a href="${createLink(controller:'rol')}">Lista de Roles</a></li>
                            <li><a href="${createLink(controller:'rolusuario')}">Asignaci&oacute;n de roles de usuario</a></li>
                        </ul>
                    </div>

                </section>
                </div>
            </div> 
  </body>
</html>