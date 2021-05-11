import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'angular-br-filters'
import 'angular-input-masks'
// import 'angularjs-currency-input-mask'
import 'bootstrap'
import '@uirouter/angularjs'
import './modules'
import navBar from './components/nav-bar/nav-bar'
import base from './components/base/base'

import { userModule } from './modules/user'
import { accountModule } from './modules/account'
import { transactionModule } from './modules/transaction'

import { AppController } from './app.controller'
import './app.module.scss'

const appModule = angular.module('app', [
  'ui.bootstrap',
  'ui.carousel',
  'ui.router',
  'ui.utils.masks',
  'idf.br-filters',
  // 'cur.$mask',
  // 'ngMask',
  // 'app.account',
  'app.auth',
  'app.management',
  // 'app.home',
  // 'app.user',
  // 'ngRoute',
  userModule,
  accountModule,
  transactionModule,
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