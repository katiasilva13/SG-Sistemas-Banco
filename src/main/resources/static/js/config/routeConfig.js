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
            .when("/contas", {
                templateUrl: "./view/contas.html",
                controller: "contasCtrl",
                resolve: {
                    contas: function (contasAPI) {
                        return contasAPI.getContas();
                    }
                }
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
