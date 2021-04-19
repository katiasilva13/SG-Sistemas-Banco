angular.module("banco").factory("usuariosAPI", function ($http, config) {
	var _getUsuarios = function () {
		return $http.get(config.baseUrl + "/usuarios");
	};

	var _getUsuario = function (id) {
		return $http.get(config.baseUrl + "/usuarios/" + id);
	};

	var _saveUsuario = function (usuario) {
		return $http.post(config.baseUrl + "/usuarios", angular.toJson(usuario));
	};

	var _deleteUsuario = function (id) {
		return $http.delete(config.baseUrl + "/usuarios/" + angular.toJson(id));
	};
	 
	return {
		getUsuarios: _getUsuarios,
		getUsuario: _getUsuario,
		saveUsuario: _saveUsuario,
		deleteUsuario: _deleteUsuario
	};
});