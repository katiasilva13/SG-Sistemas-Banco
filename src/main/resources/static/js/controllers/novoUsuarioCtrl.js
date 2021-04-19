angular.module("banco").controller("novoUsuarioCtrl", function ($scope, usuariosAPI,
    //  operadoras,
      $location) {
	$scope.app = "Novo Usuário";
	// $scope.operadoras = operadoras.data;

	$scope.adicionarUsuario = function (usuario) {
		usuariosAPI.saveUsuario(usuario).then( (res) => {
			delete $scope.usuario;
			$scope.usuarioForm.$setPristine();
			$location.path("/usuarios");
		});
	};
	$scope.isPfRoute = () => {
		return location.href.includes('/pf')
   }
	$scope.isPjRoute = () => {
		return location.href.includes('/pj')
   }

});