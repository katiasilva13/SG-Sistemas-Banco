import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'bootstrap'
import '@uirouter/angularjs'
import './modules'
import navBar from './components/nav-bar/nav-bar'
import base from './components/base/base'

// import name from './filters/nameFilter'

// import filters from './filters/index';
// import  './filters';

import './app.module.scss'
// import nameFilter from './filters/nameFilter'

angular.module('app', [
  'ui.bootstrap',
  'ui.carousel',
  'ui.router',
  'app.account',
  'app.auth',
  'app.management',
  'app.user',
])
.component('navbar', navBar)
.component('base', base)
// .filter(filters.toString, () => filters)
// .filters('name', name)
.filter('nameFilter', function (input:string) {
  var listaDeNomes = input.split(" ");
  var listaDeNomesFormatada = listaDeNomes.map(function (nome) {
      if (nome.length <= 3) {
          if (/(DA|DE|DO|DAS|DOS)/.test(nome))
              return nome.substring(0).toLowerCase()
      }
      return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
  });
  return listaDeNomesFormatada.join(" ");
})
.config(['$stateProvider', '$urlRouterProvider', ($stateProvider, $urlRouterProvider) => {
  $stateProvider
    .state('app', {
      abstract: true,
      component: 'base'
    })
  $urlRouterProvider.otherwise('/')
}])
