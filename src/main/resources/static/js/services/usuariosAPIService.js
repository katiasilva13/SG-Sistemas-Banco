angular.module("banco").factory("usuariosAPI", function ($http, config) {
	var _getUsuarios = function () {
		return $http.get(config.baseUrl + "/usuarios");
	};

	var _getUsuario = function (id) {
		return $http.get(config.baseUrl + "/usuarios/" + id);
	};

	var _saveUsuario = function (usuario) {
		return $http.post(config.baseUrl + "/usuarios", usuario);
	};
	 
	// var _getContato = function (id) {
	// 	return $http.get(config.baseUrl + "/contatos/:id" + id);
	// };

	// var _saveContato = function (contato) {
	// 	return $http.post(config.baseUrl + "/contatos", json(contato));
	// };
	 
	return {
		getUsuarios: _getUsuarios,
		getUsuario: _getUsuario,
		saveUsuario: _saveUsuario
	};
});