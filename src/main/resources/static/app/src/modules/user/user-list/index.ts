import * as angular from 'angular'
import './user-list.scss'
import template from './user-list.html'
import { UserListController } from './user-list.html'

const userListModule = angular
    .module('mbg.user.list', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.user.list', {
                url: '/list',
                templateUrl: template,
                controller: UserListController,
                controllerAs: '$ctrl'
            })
    }])
    .name

export { userListModule }