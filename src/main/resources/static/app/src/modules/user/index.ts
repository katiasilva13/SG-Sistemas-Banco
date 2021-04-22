import * as angular from 'angular'
import usersTemplate from './users/users.html'
import UsersController from './users/users'
// import UserFactory from './model/factory/user-factory'
import UserService from './services/user-service'

const userModule = angular.module('app.user', [])
    // .factory('userFactory', () => new UserFactory())
    .service('userService', UserService)
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.getUsers', {
                url: '/users',
                templateUrl: usersTemplate,
                controller: UsersController,
                controllerAs: '$ctrl',
                resolve: {
                    users: ['userService', (userService) => userService.getUsers()]
                  }
            })
    }])