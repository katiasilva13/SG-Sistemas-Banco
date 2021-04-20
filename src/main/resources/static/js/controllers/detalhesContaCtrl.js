angular.module("banco").controller("detalhesContaCtrl", function ($scope, $routeParams, conta) {
	$scope.app = "Conta";
	$scope.conta = conta.data;	
});