angular.module("banco").controller("detalhesUsuarioCtrl", function ($scope, $routeParams, usuario) {
	$scope.app = "Usuário";
	$scope.usuario = usuario.data;	
});