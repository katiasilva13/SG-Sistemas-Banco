import * as angular from 'angular'
import 'angular-ui-bootstrap'
import 'angular-ui-carousel'
import 'bootstrap'
import '@uirouter/angularjs'
// import './modules'
import navBar from './components/navbar/navbar'
import base from './components/base/base'

import './app.module.scss'

angular.module('app', [
  'ui.bootstrap',
  'ui.carousel',
  'ui.router',
//   'app.account',
            //   'app.auth',
//   'app.manager',

    'app.user',

])
.component('navbar', navBar)
.component('base', base)
.config(['$stateProvider', '$urlRouterProvider', ($stateProvider, $urlRouterProvider) => {
  $stateProvider
    .state('app', {
        abstract: true,
        component: 'base'
    //  url: '/',
    //  template: `<h1>Hello World - app.module.ts</h1>
    //         <button ui-sref='second()'>Second</button>`
    })
    // .state('second', {
    //     url: '/second',
    //     template: `<h1>Second</h1>`
    //    })
 
//   $urlRouterProvider.otherwise('/login')
  $urlRouterProvider.otherwise('/')
}])
// .run(['$rootScope', '$state', '$stateParams', 'userService', ($rootScope, $state, 
//     $stateParams, userService) => {
//   $rootScope.$on('$locationChangeSuccess', (event, toUrl) => {
//     const isAlreadyHome = toUrl.match(/https?:\/\/[\s\S]*\/#!\/(login\/?)?$/g)
//     if (!userService.getUser() && !isAlreadyHome) {
//       $state.go('app.home')
//     }
//   })
// }])