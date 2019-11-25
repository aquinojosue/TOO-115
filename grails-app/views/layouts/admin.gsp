<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <asset:stylesheet src="bootmin/bootstrap.min.css"/>
    <asset:stylesheet src="bootmin/fontawesome-all.min.css"/>
    <asset:stylesheet src="bootmin/bootadmin.css"/>
    
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <title>
        <g:layoutTitle default="Grails"/>
    </title>
</head>
<body class="bg-light">

<nav class="navbar navbar-expand navbar-dark bg-primary">
    <a class="sidebar-toggle mr-3" href="#"><i class="fa fa-bars"></i></a>
    <a class="navbar-brand" href="#">Sondeo de Precios</a>

    <div class="navbar-collapse collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a href="#" id="dd_user" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${applicationContext.springSecurityService.currentUser}</a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd_user">
                    <g:link class="dropdown-item" controller="logout">Cerrar sesión</g:link>
                </div>
            </li>
        </ul>
    </div>
</nav>
<g:set var="controllerSec" bean="controllerService"/>
<div class="d-flex">
    <div class="sidebar sidebar-dark bg-dark">
        <ul class="list-unstyled">
            <li>
                <g:link controller="home">
                    <i class="fa fa-fw fa-home"></i> Inicio
                </g:link>
            <li>
            <g:securedGroup controllerCheck="producto, precio, presentacion, categoria, unidadmedida, marca">
                <li>
                    <a href="#nav_productos" data-toggle="collapse">
                        <i class="fa fa-fw fa-cube"></i> Productos
                    </a>
                    <ul id="nav_productos" class="list-unstyled collapse">
                        <g:securedElement controllerCheck="producto" faIcon="list" elementLabel="Lista de Productos" />
                        <g:securedElement controllerCheck="precio" faIcon="dollar-sign" elementLabel="Precios" />
                        <g:securedElement controllerCheck="presentacion" faIcon="box" elementLabel="Presentaciones" />
                        <g:securedElement controllerCheck="categoria" faIcon="tag" elementLabel="Categorías" />
                        <g:securedElement controllerCheck="unidadmedida" faIcon="balance-scale" elementLabel="Unidades de medida" />
                        <g:securedElement controllerCheck="marca" faIcon="trademark" elementLabel="Marcas" />
                    </ul>
                </li>
            </g:securedGroup>
            <g:securedGroup controllerCheck="mercado, municipio, departamento, tipoMercado">
                <li>
                    <a href="#nav_ubicaciones" data-toggle="collapse">
                        <i class="fa fa-fw fa-map-marker-alt"></i> Ubicaciones
                    </a>
                    <ul id="nav_ubicaciones" class="list-unstyled collapse">
                        <g:securedElement controllerCheck="mercado" faIcon="shopping-cart" elementLabel="Mercados" />
                        <g:securedElement controllerCheck="tipoMercado" faIcon="tag" elementLabel="Tipo de Mercado" />
                        <g:securedElement controllerCheck="municipio" faIcon="map" elementLabel="Municipios" />
                        <g:securedElement controllerCheck="departamento" faIcon="map" elementLabel="Departamentos" />
                    </ul>
                </li>
            </g:securedGroup>
            <g:securedGroup controllerCheck="usuario, permiso">
                <li>
                    <a href="#nav_usuarios" data-toggle="collapse">
                        <i class="fa fa-fw fa-address-card"></i> Usuarios
                    </a>
                    <ul id="nav_usuarios" class="list-unstyled collapse">
                        <g:securedElement controllerCheck="usuario" faIcon="address-book" elementLabel="Lista de usuarios" />
                        <g:securedElement controllerCheck="rol" faIcon="user-tag" elementLabel="Roles de Usuario" />
                        <g:securedElement controllerCheck="permiso" faIcon="link" elementLabel="Permisos" />
                    </ul>
                </li>
            </g:securedGroup>
        </ul>
    </div>

    <div class="content p-4">
        <g:layoutBody/>
    </div>
</div>
<asset:javascript src="jquery.min.js"/>
<asset:javascript src="bootstrap.bundle.min.js"/>
<asset:javascript src="bootadmin.min.js"/>

</body>
</html>