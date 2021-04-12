angular
  .module("listaTelefonica")
  .config(function config($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider
      .when("/contatos", {
        templateUrl: "./view/contatos.html",
        controller: "listaTelefonicaCtrl",
        resolve: {
            contatos: function (contatosAPI) {
                return contatosAPI.getContatos();
              },
            operadoras: function (operadorasAPI) {
            return operadorasAPI.getOperadoras();
          }
        },
      })
      .when("/novoContato", {
        templateUrl: "./view/novoContato.html",
        controller: "novoContatoCtrl",
        resolve: {
          operadoras: function (operadorasAPI) {
            return operadorasAPI.getOperadoras();
          }
        },
      })
      .when("/detalhesContato/:id", {
        templateUrl: "./view/detalhesContato.html",
        controller: "detalhesContatoCtrl",
        resolve: {
          contato: function (contatosAPI, $route) {
            return contatosAPI.getContato($route.current.params.id);
          }
        },
      })
      .when("/error", {
        templateUrl: "./view/error.html"        
      })
      .otherwise("/", {
        redirectTo: "./index.html",
      });
  });
