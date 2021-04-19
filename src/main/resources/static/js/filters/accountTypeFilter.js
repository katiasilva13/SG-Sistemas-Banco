angular.module("banco").filter("accountType", function () {
	return function (input) {
		if (/(CHECKING_ACCOUNT)/.test(input)) return "Corrente";
		if (/(SAVINGS_ACCOUNT)/.test(input)) return "Poupança";		
	};
});