<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index">Lista de roles</g:link></li>
            </ul>
        </div>
        <div class="content scaffold-show" role="main">
            <h1>Asignar rol a ${usuario.username}</h1>
            <div class="content scaffold-edit" role="main">
                <g:form controller="rolusuario" action="save">
                    <fieldset class="form">
                        <label>Rol: ${indice}</label>
                        <g:select name="chosenRole" from="${roles.authority}" value="${selected.authority}"  noSelection="['':'-Escoge el rol-']"/><br/>
                    </fieldset>
                    <g:hiddenField name="userID" value="${userID}" />
                    <fieldset class="buttons">
                        <g:actionSubmit class="save" value="Save"/>
                    </fieldset>
                </g:form>
            </div>
        </div>
	</body>
</html>