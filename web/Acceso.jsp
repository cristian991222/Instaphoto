
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./MDB-Free/css/bootstrap.css">
        <link rel="stylesheet" href="./MDB-Free/css/mdb.min.css">
        <link rel="stylesheet" href="./fontawesome/css/all.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=KoHo|Poppins:300" rel="stylesheet">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>

        <nav class="navbar fixed-top navbar-expand-lg navbar-dark unique-color-dark">
            <a class="navbar-brand ml-2" href="#">Project logo</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse ml-1" id="navbarSupportedContent">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <ul class="navbar-nav mt-2">
                                <li class="nav-item">
                                    <a href="mainPage.html" class="mt-1 nav-link">Bienvenidos</a>
                                </li>
                                <li class="nav-item">
                                    <a id="contentMisionId" href="contentMision" class="mt-1 nav-link">Características</a>
                                </li>
                                <li class="nav-item">
                                    <a class="mt-1 nav-link" href="./portafolio.html">Portafolio</a>
                                </li>
                            </ul>
                        </div>    
                        <div class="col-md-6">
                            <div class="d-flex justify-content-end mt-1">
                                <a href="Acceso.jsp" id="btnAccess" class="btn color-block blue-gradient z-depth-2">
                                    Ingresar
                                </a>
                            </div>    
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container mt-5">
            <div class="row mt-3">
                <%%>
                <div id="alert-login" style="position: absolute; left: 0; right: 0; z-index:1000;" class="d-none accent-1w-50 mt-5 mx-auto alert alert-warning alert-dismissible fade show" role="alert" >
                    <p class="font-weight-bold">Credenciales de acceso incorrectas</p>Verifica tus datos.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="col-12">
                    <div class="my-3 p-3">
                        <ul class="nav nav-tabs nav-pills nav-fill bg-primary text-primary" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="login-tab" data-toggle="tab" href="#login" role="tab" aria-controls="home"
                                   aria-selected="true">Inicio de sesión</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="registro-tab" data-toggle="tab" href="#registro" role="tab" aria-controls="profile"
                                   aria-selected="false">Registro</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="login" role="tabpanel" aria-labelledby="login-tab">
                                <!-- Default form login -->
                                <form style="margin-top: 2em;" method="post" class="text-center mx-auto w-75 border border-light p-5">
                                    <p class="h4 mt-2 mb-5">Inicio de sesión</p>

                                    <div class="form-group mx-auto w-50">
                                        <input type="email" id="IdTxtCorreo" name="txtCorreo" class="form-control mb-4" placeholder="Ingrese correo electrónico">    
                                    </div>

                                    <div class="form-group mx-auto w-50">
                                        <input type="password" id="IdTxtClave" name="txtClave" class="form-control mb-4" placeholder="Ingrese su contraseña">    
                                    </div>

                                    <button type="submit" id="btnIngreso" class="btn btn-success mx-auto w-25 my-4">Ingresar</button>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="registro" role="tabpanel" aria-labelledby="registro-tab">
                                <div class="my-5 mx-auto w-75 ">
                                    <div class="mt-5">
                                        <form id="frmUsuario" style="margin-top: 2em;" method="post" class="text-center border border-light p-5">
                                            <p class="h4 mb-4">Registrate ahora</p>
                                            <div class="form-row mb-4">
                                                <div class="col">
                                                    <input type="text" id="txtNombres" name="txtNombre" class="form-control" required="required" placeholder="Ingresa tu nombre">
                                                </div>
                                                <div class="col">
                                                    <input type="text" id="txtApellidos" name="txtApellidos" class="form-control" required="required" placeholder="Ingresa tu apellido">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <input type="email" id="txtCorreo" name="txtEmail" class="form-control mb-4" required="required" placeholder="Correo">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" id="txtClave" name="txtClave" class="form-control" required="required" placeholder="Contraseña" aria-describedby="defaultRegisterFormPasswordHelpBlock">
                                            </div>
                                            <div class="form-group">
                                                <small class="text-left form-text text-muted">Fecha de nacimiento</small>
                                                <input type="date" id="DtFechaNacimiento" name="DtfechaNacimiento"  required="required" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <input type="text" id="txtNumeroCelular" name="txtNumeroCelular" class="form-control" placeholder="Número de celular" aria-describedby="defaultRegisterFormPhoneHelpBlock">
                                                <small id="defaultRegisterFormPhoneHelpBlock" class="text-left form-text text-muted mb-4">
                                                    Número de celular opcional
                                                </small>
                                            </div>

                                            <!-- Sign up button -->
                                            <button id="btnRegistrar" class="btn btn-info my-4 btn-block" type="submit">Registrar</button>
                                            <hr>
                                            <small class="text-center text-secondary">Todos los derechos reservados</small>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        </div>



        <script src="./MDB-Free/js/jquery-3.3.1.min.js"></script>
        <script src="./MDB-Free/js/popper.min.js"></script>
        <script src="./MDB-Free/js/bootstrap.min.js"></script>
        <script src="./MDB-Free/js/mdb.min.js"></script>
        <script src="./js/main.js"></script>
        <script src="./js/routes.js"></script>
        <script src="./js/Peticiones.js"></script>
    </body>
</html>