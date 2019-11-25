<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <asset:stylesheet src="bootmin/bootstrap.min.css"/>
    <asset:stylesheet src="bootmin/fontawesome-all.min.css"/>
    <asset:stylesheet src="bootmin/bootadmin.min.css"/>

    <title>Login
    </title>
</head>
<body class="bg-light">
    <div class="container h-100">
        
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-md-4">
                <h2 class="text-center mb-4"><g:message code='springSecurity.login.header'/></h2>
                <div class="card">
                    <div class="card-body">
                        
                        <g:if test='${flash.message}'>
                            <div class="alert alert-danger" role="alert">
                                <div class="login_message">${flash.message}</div>
                            </div>
                        </g:if>
                        <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="${usernameParameter ?: 'username'}" id="username" autocapitalize="none" placeholder="${message(code: 'springSecurity.login.username.label')}" required=""/>
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fa fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" name="${passwordParameter ?: 'password'}" id="password" placeholder="${message(code: 'springSecurity.login.password.label')}" required=""/>
                            </div>

                            <div class="form-check mb-3">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>/>
                                    <g:message code='springSecurity.login.remember.me.label'/>
                                </label>
                            </div>

                            <div class="col pr-2">
                                <input type="submit" class="btn btn-block btn-primary" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<asset:javascript src="jquery.min.js"/>
<asset:javascript src="bootstrap.bundle.min.js"/>
<asset:javascript src="bootadmin.min.js"/>

</body>
</html>