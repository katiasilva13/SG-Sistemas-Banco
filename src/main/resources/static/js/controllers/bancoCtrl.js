angular.module("banco").controller("bancoCtrl", function ($scope, usuarios, contas
	//operadoras, serialGenerator, uppercaseFilter
	) {
	$scope.app = "Banco";
	$scope.usuarios = usuarios.data;
	 $scope.contas = contas.data;

	// var generateSerial = function (contatos) {
	// 	contatos.forEach(function (item) {
	// 		item.serial = serialGenerator.generate();
	// 	});
	// };

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

	// generateSerial($scope.contatos);
});