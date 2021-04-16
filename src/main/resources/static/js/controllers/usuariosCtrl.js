angular
  .module("banco")
  .controller("usuariosCtrl", function ($scope, usuarios) {
    $scope.app = "Banco: Usuários";
    $scope.usuarios = usuarios.data;

    $scope.apagarUsuarios = function (usuarios) {
      $scope.usuarios = usuarios.filter(function (usuario) {
        if (!usuario.selecionado) return usuario;
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

  });
