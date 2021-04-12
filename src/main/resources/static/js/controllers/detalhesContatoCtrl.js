angular.module("listaTelefonica").controller("detalhesContatoCtrl", function ($scope, $routeParams, contato) {
	$scope.app = "Detalhes";
	$scope.contato = contato.data;	
});