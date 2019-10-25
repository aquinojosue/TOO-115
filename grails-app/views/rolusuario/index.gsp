

<!DOCTYPE html>
<html lang="en" class="no-js">
  <head>
        <meta name="layout" content="main" />
        <title>Roles de usuario</title>
</head>
  <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
            <div class="content scaffold-show" role="main">
                <h1>Roles de usuario</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Rol</th>
                            <th>Acci&oacute;n</th>
                        </tr>
                    </thead>
                    <tbody>    
                        <g:each  in="${userRoles}">
                            <tr>
                                <td>${it.usuario.username}</td>
                                <td>${it.rol.authority}</td>
                                <td><a href="${createLink(action: 'edit', id: it.usuario.id)}">Editar</a></td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>  
  </body>
</html>