import * as angular from 'angular'
import './user-list.scss'
import template from './user-list.html'
import { UserListController } from './user-list.html'
import { UserService } from '../services/user-service'

const userListModule = angular
    .module('app.user.list', [])
    .service('userService', UserService)
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.user.list', {
                url: '/list',
                templateUrl: template,
                controller: UserListController,
                controllerAs: '$ctrl',
                resolve: {
                    users: ['userService', (userService) => userService.getUsers().then(response => response.data)]
                }
            })
    }])
    .name

export { userListModule }