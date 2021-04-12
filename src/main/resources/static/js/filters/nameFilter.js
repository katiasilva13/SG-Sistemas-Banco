angular.module("listaTelefonica").filter("name", function () {
	return function (input) {
		var listaDeNomes = input.split(" ");
		var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
			if(nome.length <= 3) {
            		if(/(DA|DE|DO|DAS|DOS)/.test(nome)) 
                        return  nome.substring(0).toLowerCase()
         		}
			return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
		});
		return listaDeNomesFormatada.join(" ");
	};
});