import * as angular from 'angular'
import usersTemplate from './users/users.html'
import detailsTemplate from './details/details.html'
// import registerTemplate from './register/register.html'

import DetailsController from './details/details'
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
            .state('app.details', {
                url: '/users/:id',
                params: {
                    id: null
                },
                templateUrl: detailsTemplate,
                controller: DetailsController,
                controllerAs: '$ctrl',  
                resolve: {
                    user: ['$stateParams', 'userService', ($stateParams, userService) => 
                        userService.getById($stateParams.id)]
                  }
            })
    }])