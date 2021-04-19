angular
  .module("banco")
  .controller("contasCtrl", function ($scope, contas) {
    $scope.app = "Banco: Contas";
    $scope.contas = contas.data;

    $scope.apagarContas = function (contas) {
      $scope.contas = contas.filter(function (conta) {
        if (!conta.selecionado) return conta;
      });
    };
    $scope.isContasSelecionado = function (contas) {
      return contas.some(function (conta) {
        return conta.selecionado;
      });
    };
    $scope.ordenarPor = function (campo) {
      $scope.criterioDeOrdenacao = campo;
      $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };

  });
