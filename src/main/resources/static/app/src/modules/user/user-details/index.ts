import * as angular from 'angular'
import './user-details.scss'
import template from './user-details.html'
import { UserDetailsController } from './user-details'

const userDetailsModule = angular
    .module('app.user.details', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.user.details', {
                url: '/users/:id',
                params: {
                    id: null
                },
                templateUrl: template,
                controller: UserDetailsController,
                controllerAs: '$ctrl',
                resolve: {
                    user: ['$stateParams', 'userService', ($stateParams, userService) =>
                        userService.getById($stateParams.id).then(response => response.data)]
                }
            })
    }])
    .name

export { userDetailsModule }