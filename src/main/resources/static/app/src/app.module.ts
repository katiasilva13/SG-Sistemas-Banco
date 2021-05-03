import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'bootstrap'
import '@uirouter/angularjs'
import './modules'
import navBar from './components/nav-bar/nav-bar'
import base from './components/base/base'

import { userModule } from './modules/user'

// import { accountModule } from './modules/account'

import { AppController } from './app.controller'
import './app.module.scss'

const appModule = angular.module('app', [
  'ui.bootstrap',
  'ui.carousel',
  'ui.router',
  'app.account',
  'app.auth',
  'app.management',
  'app.user',
    userModule,
])
.component('navbar', navBar)
.component('base', base)


// appModule.controller('app.controller', AppController)
.config(['$stateProvider', '$urlRouterProvider', ($stateProvider, $urlRouterProvider) => {
  $stateProvider
    .state('app', {
      abstract: true,
      component: 'base'
    })
  $urlRouterProvider.otherwise('/')
}])

export { appModule }