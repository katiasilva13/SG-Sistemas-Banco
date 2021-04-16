angular.module("banco").controller("novoUsuarioCtrl", function ($scope, usuariosAPI,
    //  operadoras,
      $location) {
	$scope.app = "Usuário";
	// $scope.operadoras = operadoras.data;

	$scope.adicionarUsuario = function (usuario) {
		usuariosAPI.saveUsuario(usuario).then( (res) => {
			delete $scope.usuario;
			$scope.usuarioForm.$setPristine();
			$location.path("/usuarios");
		});
	};

});