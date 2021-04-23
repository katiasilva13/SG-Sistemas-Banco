
// angular.module("app").filter("name", function () {
// 	return function (input) {
// 		var listaDeNomes = input.split(" ");
// 		var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
// 			if(nome.length <= 3) {
//             		if(/(DA|DE|DO|DAS|DOS)/.test(nome)) 
//                         return  nome.substring(0).toLowerCase()
//          		}
// 			return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
// 		});
// 		return listaDeNomesFormatada.join(" ");
// 	};
// });

const nameFilter = (input: string) => {
    return function (input) {
        var listaDeNomes = input.split(" ");
        var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
            if (nome.length <= 3) {
                if (/(DA|DE|DO|DAS|DOS)/.test(nome))
                    return nome.substring(0).toLowerCase()
            }
            return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
        });
        return listaDeNomesFormatada.join(" ");
    };
}
export default nameFilter;

// const limiter = (input:string, maxsize:number) =>  {
//     if(input.length <= 2) return input;
//     var out = input.substring(0,(maxsize || 2 ))+"...";
//     return out;        
// }
// export default limiter;


// import * as angular from 'angular'
// function NameFilter($filter) {
//     return function (input) {
//         console.log("nameFilter.ts line 19")
//         		var listaDeNomes = input.split(" ");
//         		var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
//         			if(nome.length <= 3) {
//                     		if(/(DA|DE|DO|DAS|DOS)/.test(nome)) 
//                                 return  nome.substring(0).toLowerCase()
//                  		}
//         			return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
//         		});
//         		return listaDeNomesFormatada.join(" ");
//         	};
// }
// module NameFilter {
//     export var $inject = ['$filter'];
// }

// angular.module("app").filter("NameFilter", NameFilter);

// function FriendlyDateFilter($filter) {
//     return function (s: string): string {
//         /* Your logic here */
//     }
//     /* Helper logic here */
// }
// module FriendlyDateFilter {
//     export var $inject = ['$filter'];
// }

// angular.module("ReadingLog").filter("FriendlyDateFilter", FriendlyDateFilter);

// app nameFilterModule  {
//     export function nameFilter() {
//             return function (input) {
//                 var listaDeNomes = input.split(" ");
//                 var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
//                 if(nome.length <= 3) {
//                         if(/(DA|DE|DO|DAS|DOS)/.test(nome)) 
//                             return  nome.substring(0).toLowerCase()
//                     }
//                 return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
//             });
// 		    return listaDeNomesFormatada.join(" ");
//         }
//     }
// }
// myModule.filter("name", nameFilterModule.nameFilter);

// module moduleName {
//     export function myFilter()
//     {
//         return function(input)
//         {
//             //  filter stuff here
//             return result;
//         }
//     }
// }
// then outside the module:

// myModule.filter("filterName", moduleName.myFilter);