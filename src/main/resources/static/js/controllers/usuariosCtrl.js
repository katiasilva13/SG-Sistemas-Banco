angular
  .module("banco")
  .controller("usuariosCtrl", function ($scope, usuarios, usuariosAPI) {
    $scope.app = "Banco: Usuários";
    $scope.usuarios = usuarios.data;

    $scope.apagarUsuarios = function (usuarios) {
      usuarios.filter(function (usuario) {
        if (usuario.selecionado) {
          // function (usuariosAPI, $route) {
            // usuariosAPI.deleteUsuario($route.current.params.id);

            usuariosAPI.deleteUsuario(usuario.id);
          // }
        }
      });
      return usuariosAPI.getUsuarios();
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

  });
