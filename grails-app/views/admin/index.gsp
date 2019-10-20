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
                            <li>Usuarios</li>
                            <li>Roles</li>
                            <li>Asignacion de Roles de Usuario</li>
                        </ul>
                    </div>
                    <div class="col-md-2">
                        <div class="card" style="width: 18rem;">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Cras justo odio</li>
                                <li class="list-group-item">Dapibus ac facilisis in</li>
                                <li class="list-group-item">Vestibulum at eros</li>
                            </ul>
                            <div class="card-body">
                                <a href="#" class="card-link">Card link</a>
                                <a href="#" class="card-link">Another link</a>
                            </div>
                    </div>

                </section>
                </div>
            </div> 
  </body>
</html>