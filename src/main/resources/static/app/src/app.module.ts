import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'bootstrap'
import '@uirouter/angularjs'
import './modules'
import navBar from './components/nav-bar/nav-bar'
import base from './components/base/base'

// import name from './filters/nameFilter'

import filters from './filters/index';
// import  './filters';

import './app.module.scss'

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
.config(['$stateProvider', '$urlRouterProvider', ($stateProvider, $urlRouterProvider) => {
  $stateProvider
    .state('app', {
      abstract: true,
      component: 'base'
    })
  $urlRouterProvider.otherwise('/')
}])
