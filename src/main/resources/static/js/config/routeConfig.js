angular
    .module("banco")
    .config(function config($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix("");
        $routeProvider
            .when("/usuarios", {
                templateUrl: "./view/usuarios.html",
                controller: "bancoCtrl",
                resolve: {
                    usuarios: function (usuariosAPI) {
                        return usuariosAPI.getUsuarios();
                    }
                }
            })
            .when("/contas", {
                templateUrl: "./view/contas.html",
                controller: "bancoCtrl",
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
            .otherwise("/", {
                redirectTo: "./index.html",
            });
    });
