angular.module("listaTelefonica").directive("uiAlert", function (){
    return {        
        templateUrl: "view/alert.html", 
        replace: true,
       restrict: "AE",
       scope: {
           //se o nome da propriedade da diretiva e do atributo são iguais, basta pôr o @ ou =
        title: "@" 
       },
       transclude: true
    }
});