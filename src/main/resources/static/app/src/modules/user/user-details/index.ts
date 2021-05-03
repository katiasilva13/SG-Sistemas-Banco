import * as angular from 'angular'
import './user-details.scss'
import template from './user-details.html'
import { UserDetailsController } from './user-details'

const userDetailsModule = angular
    .module('app.user.details', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.user.details', {
                url: '/details',
                templateUrl: template,
                controller: UserDetailsController,
                controllerAs: '$ctrl'
            })
    }])
    .name

export { userDetailsModule }