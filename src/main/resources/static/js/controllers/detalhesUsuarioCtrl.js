angular.module("banco").controller("detalhesUsuarioCtrl", function ($scope, $routeParams, usuario) {
	$scope.app = "Detalhes";
	$scope.usuario = usuario.data;	
});