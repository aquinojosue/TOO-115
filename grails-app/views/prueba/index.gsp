<!DOCTYPE html>
<html lang="en" class="no-js">
  <head>
        <meta name="layout" content="main" />
        <title>Ila</title>
</head>
  <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
            <div class="content scaffold-show" role="main">
                <h1>Roles de usuario</h1>
                <f:table collection="mapa"/>
            </div>  
  </body>
</html>