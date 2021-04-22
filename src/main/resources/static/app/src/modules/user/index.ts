import * as angular from 'angular'
import UserController from './user/user'
import userTemplate from './user/user.html'

const userModule  =angular.module('app.user', [])
.config(['$stateProvider', ($stateProvider) => {
    $stateProvider
    .state('app.user', {
        url: '/users/',
        template: userTemplate,
        controller: UserController,
        controllerAs: '$ctrl'
       })
    // .state('app.user', {
    //     url: '/users/:id',
    //     template: userTemplate,
    //     controller: UserController,
    //     controllerAs: '$ctrl'
    //    })
}])