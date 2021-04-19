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
              usuariosAPI.deleteUsuario(usuario.id);
            }
          });
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
