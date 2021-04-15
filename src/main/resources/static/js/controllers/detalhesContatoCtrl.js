angular.module("banco").controller("detalhesContatoCtrl", function ($scope, $routeParams, contato) {
	$scope.app = "Detalhes";
	$scope.contato = contato.data;	
});