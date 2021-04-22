import * as angular from 'angular'
import loginTemplate from './login/login.html'
import LoginController from './login/login'
import UserFactory from './model/factory/user-factory'
import UserService from './services/user-service'

const authModule = angular.module('app.auth', [])
    .factory('userFactory', () => new UserFactory())
    .service('userService', UserService)
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.login', {
                url: '/login',
                templateUrl: loginTemplate,
                controller: LoginController,
                controllerAs: '$ctrl'
            })
    }])