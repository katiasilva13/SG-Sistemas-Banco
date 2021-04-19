angular
    .module("banco")
    .config(function config($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix("");
        $routeProvider
            .when("/usuarios", {
                templateUrl: "./view/usuarios.html",
                controller: "usuariosCtrl",
                resolve: {
                    usuarios: function (usuariosAPI) {
                        return usuariosAPI.getUsuarios();
                    }
                }
            })
            .when("/detalhes-usuario/:id", {
                templateUrl: "./view/detalhesUsuario.html",
                controller: "detalhesUsuarioCtrl",
                resolve: {
                    usuario: function (usuariosAPI, $route) {
                      return usuariosAPI.getUsuario($route.current.params.id);
                    }
                  },
            })
            .when("/novo-usuario/:tipo", {
                templateUrl: "./view/novoUsuario.html?tipo",
                controller: "novoUsuarioCtrl"
            })
            //TODO add rotas conta
            .when("/contas", {
                templateUrl: "./view/contas.html",
                controller: "contasCtrl",
                resolve: {
                    contas: function (contasAPI) {
                        return contasAPI.getContas();
                    }
                }
            })
            .when("/detalhes-conta/:id", {
                templateUrl: "./view/detalhesConta.html",
                controller: "detalhesContaCtrl",
                resolve: {
                    conta: function (contasAPI, $route) {
                      return contasAPI.getConta($route.current.params.id);
                    }
                  },
            })
            .when("/nova-conta/:tipo", {
                templateUrl: "./view/novaConta.html?tipo",
                controller: "novaContaCtrl" 
            })
            .when("/home", {
                templateUrl: "./view/home.html"
            })
            .when("/error", {
                templateUrl: "./view/error.html"
            })
            .otherwise("/", {
                redirectTo: "./index.html",
            });
    });
