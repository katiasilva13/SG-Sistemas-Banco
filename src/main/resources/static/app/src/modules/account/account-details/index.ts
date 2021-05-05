import * as angular from 'angular'
import './account-details.scss'
import template from './account-details.html'
import { AccountDetailsController } from './account-details'

const accountDetailsModule = angular
    .module('app.account.details', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.account.details', {
                url: '/accounts/:id',
                params: {
                    id: null
                },
                templateUrl: template,
                controller: AccountDetailsController,
                controllerAs: '$ctrl',
                resolve: {
                    account: ['$stateParams', 'accountService', ($stateParams, accountService) =>
                        accountService.getById($stateParams.id).then(response => response.data)]
                }
            })
    }])
    .name

export { accountDetailsModule }
