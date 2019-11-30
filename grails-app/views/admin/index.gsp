<html>
<%@ page import="com.enigma.SondeoPrecios.Seguridad.Usuario" %>
<%@ page import="com.enigma.SondeoPrecios.Ubicacion.*" %>
<%@ page import="com.enigma.SondeoPrecios.Producto.*" %>

<head>
    <title>Administrador</title>
</head>
<body>
    <h3 class="mb-4">Bienivenido de nuevo, ${applicationContext.springSecurityService.currentUser}</h3>

    <div class="row mb-4">
        <div class="col-md">
            <div class="d-flex border">
                <div class="bg-primary text-light p-4">
                    <div class="d-flex align-items-center h-100">
                        <i class="fa fa-3x fa-fw fa-cube"></i>
                    </div>
                </div>
                <div class="flex-grow-1 bg-white p-4">
                    <span class="text-uppercase text-secondary mb-0 ">Productos</span>
                    <h3 class="font-weight-bold mb-0">${Producto.count()}</h3>
                </div>
            </div>
        </div>
        <div class="col-md">
            <div class="d-flex border">
                <div class="bg-success text-light p-4">
                    <div class="d-flex align-items-center h-100">
                        <i class="fa fa-3x fa-fw fa-comment-dollar"></i>
                    </div>
                </div>
                <div class="flex-grow-1 bg-white p-4">
                    <span class="text-uppercase text-secondary mb-0">Precios</span>
                    <h3 class="font-weight-bold mb-0">${Precio.count()}</h3>
                </div>
            </div>
        </div>
        <div class="col-md">
            <div class="d-flex border">
                <div class="bg-danger text-light p-4">
                    <div class="d-flex align-items-center h-100">
                        <i class="fa fa-3x fa-fw fa-shopping-cart"></i>
                    </div>
                </div>
                <div class="flex-grow-1 bg-white p-4">
                    <span class="text-uppercase text-secondary mb-0">Mercados</span>
                    <h3 class="font-weight-bold mb-0">${Mercado.count()}</h3>
                </div>
            </div>
        </div>
        <div class="col-md">
            <div class="d-flex border">
                <div class="bg-info text-light p-4">
                    <div class="d-flex align-items-center h-100">
                        <i class="fa fa-3x fa-fw fa-users"></i>
                    </div>
                </div>
                <div class="flex-grow-1 bg-white p-4">
                    <span class="text-uppercase text-secondary mb-0">Usuarios</span>
                    <h3 class="font-weight-bold mb-0">${Usuario.count()}</h3>
                </div>
            </div>
        </div>
            
    </div>
        <div class="card mb-4">
        <div class="card-body">
            <h3>Últimos 5 precios</h3>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Mercado</th>
                        <th>Precio</th>
                        <th>Fecha de creación</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${Precio.list(max:5)}" var="precio">
                        <tr>
                            <td>${precio.producto}</td>
                            <td>${precio.mercado}</td>
                            <td>${precio.precio}</td>
                            <td>
                                <g:formatDate format="EEEE dd/MM/yyyy HH:mm:ss" date="${precio.dateCreated}"/>
                            </td>
                        </tr> 
                    </g:each>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>