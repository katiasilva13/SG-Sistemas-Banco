angular.module("banco").service("contasAPI", function ($http, config) {
	this.getContas = function () {
		return $http.get(config.baseUrl + "/contas");
	};
});