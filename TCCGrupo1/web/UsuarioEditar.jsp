<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <title>Nome do Projeto</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="include/css/bootstrap.css" rel="stylesheet">
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
        <link href="include/css/bootstrap-responsive.css" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="shortcut icon" href="include/img/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="include/img/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="include/img/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="include/img/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="include/img/apple-touch-icon-57-precomposed.png">
    </head>

    <body>

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Nome do Projeto</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="index.html">Principal</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Usuários <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:CadastroUsuario();">Incluir</a></li>
                                    <li><a href="javascript:ListarUsuario();">Listar</a></li>
                                </ul>
                            </li>                            
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">
            <h1>Alterar Usuário</h1>
            <form method="post" action="Servlet" name="frmPrincipal" id="frmPrincipal">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="txtNome">Informe seu nome</label>
                            <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome" value="${usuario.nome}">
                        </div>    
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="txtEmail">Informe seu email</label>
                            <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email" value="${usuario.email}">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="txtSenha">Informe sua senha</label>
                            <input type="password" class="form-control" id="txtSenha" name="txtSenha" placeholder="Senha" value="${usuario.senha}">
                        </div>
                    </div>
                </div>
                <button type="reset">Limpar</button>
                <button type="submit">Enviar</button>
                
                <input type="hidden" name="txtId" id="txtId" value="${usuario.id}">
                <input type="hidden" name="txtObjeto" id="txtObjeto" value="Usuario">
                <input type="hidden" name="txtMetodo" id="txtMetodo" value="Salvar">
                
            </form>
        </div> <!-- /container -->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="include/js/jquery.js"></script>
        <script src="include/js/bootstrap-transition.js"></script>
        <script src="include/js/bootstrap-alert.js"></script>
        <script src="include/js/bootstrap-modal.js"></script>
        <script src="include/js/bootstrap-dropdown.js"></script>
        <script src="include/js/bootstrap-scrollspy.js"></script>
        <script src="include/js/bootstrap-tab.js"></script>
        <script src="include/js/bootstrap-tooltip.js"></script>
        <script src="include/js/bootstrap-popover.js"></script>
        <script src="include/js/bootstrap-button.js"></script>
        <script src="include/js/bootstrap-collapse.js"></script>
        <script src="include/js/bootstrap-carousel.js"></script>
        <script src="include/js/bootstrap-typeahead.js"></script>

        <script>

            function CadastroUsuario() {
                document.getElementById("txtObjeto").value = 'Usuario';
                document.getElementById("txtMetodo").value = 'Cadastrar';
                document.getElementById("frmPrincipal").submit();
            }

            function ListarUsuario() {
                document.getElementById("txtObjeto").value = 'Usuario';
                document.getElementById("txtMetodo").value = 'Listar';
                document.getElementById("frmPrincipal").submit();
            }

        </script>

    </body>
</html>