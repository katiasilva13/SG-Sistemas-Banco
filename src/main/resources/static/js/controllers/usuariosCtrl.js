angular
  .module("banco")
  .controller(
    "usuariosCtrl",
    function ($scope, usuarios, usuariosAPI, $location) {
      $scope.app = "Banco: Usuários";
      $scope.usuarios = usuarios.data;

      $scope.reloadRoute = function() {
        $location.reload();
     }

      $scope.apagarUsuarios = function (usuarios) {
        usuarios
          .filter(function (usuario) {
            if (usuario.selecionado) {
              console.log(usuario);
              // function (usuariosAPI, $route) {
              // usuariosAPI.deleteUsuario($route.current.params.id);
              usuariosAPI.deleteUsuario(usuario.id);
              // }
            }
          // })
          // .then(
          //   function( data ) {
          //      console.log(data);
          //      $state.reload();
              //$state.go('survey.surveyList',{id: 0});
              // $("#deleteProject").modal("hide");
          //  });
          // .then((res) => {
          //   reloadRoute();
            // function locationreload() {   
          //     // To reload the entire page from the server
          //     location.reload();       
          //     }
          //   // $location.path("/contatos");
          //   $location.path("/home");
            //  $location.reload();
          });
        // return usuariosAPI.getUsuarios();

        // $location.path("/home");
        // return $location.reload();
      };

      $scope.isUsuarioSelecionado = function (usuarios) {
        return usuarios.some(function (usuario) {
          return usuario.selecionado;
        });
      };
      $scope.ordenarPor = function (campo) {
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
      };
    }
  );
