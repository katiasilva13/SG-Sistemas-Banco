angular
  .module("banco")
  .controller("contasCtrl", function ($scope, contas, contasAPI) {
    $scope.app = "Banco: Contas";
    $scope.contas = contas.data;

    $scope.apagarContas = function (contas) {
      contas
        .filter(function (conta) {
          if (conta.selecionado) {
            contasAPI.deleteUsuario(conta.id);
          }
        });
    };

    $scope.isContaSelecionado = function (contas) {
      return contas.some(function (conta) {
        return conta.selecionado;
      });
    };
    $scope.ordenarPor = function (campo) {
      $scope.criterioDeOrdenacao = campo;
      $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };

  });
