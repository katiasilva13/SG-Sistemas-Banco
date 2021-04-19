angular.module("banco").service("contasAPI", function ($http, config) {

	var _getContas = function () {
		return $http.get(config.baseUrl + "/contas");
	};

	var _getConta = function (id) {
		return $http.get(config.baseUrl + "/contas/" + id);
	};

	var _saveConta = function (conta) {
		return $http.post(config.baseUrl + "/contas", angular.toJson(conta));
	};

	var _deleteConta = function (id) {
		return $http.delete(config.baseUrl + "/contas/" + angular.toJson(id));
	};
	 
	return {
		getContas: _getContas,
		getConta: _getConta,
		saveConta: _saveConta,
		deleteConta: _deleteConta
	};
});