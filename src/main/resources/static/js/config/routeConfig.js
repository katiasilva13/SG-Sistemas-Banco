angular
    .module("banco")
    .config(function config($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix("");
        $routeProvider
            .when("/usuarios", {
                templateUrl: "./view/usuarios.html",
                // controller: "bancoCtrl",
                controller: "usuariosCtrl",
                resolve: {
                    usuarios: function (usuariosAPI) {
                        return usuariosAPI.getUsuarios();
                    }
                }
            })
            .when("/detalhes-usuario/:id", {
                templateUrl: "./view/detalhesUsuario.html",
                // controller: "bancoCtrl",
                controller: "detalhesUsuarioCtrl",
                resolve: {
                    usuario: function (usuariosAPI, $route) {
                      return usuariosAPI.getUsuario($route.current.params.id);
                    }
                  },
            })
            .when("/novo-usuario/:tipo", {
                templateUrl: "./view/novoUsuario.html?tipo",
                // controller: "bancoCtrl",
                controller: "novoUsuarioCtrl" //,
                // resolve: {
                //     usuario: function (usuariosAPI, $route) {
                //       return usuariosAPI.getUsuario($route.current.params.id);
                //     }
                //   },
            })
            //TODO add rotas
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
            // .when("/index", {
            //     templateUrl: "./index.html"
            // })
            .otherwise("/", {
                // redirectTo: "./view/home.html",
                redirectTo: "./index.html",
            });
    });
