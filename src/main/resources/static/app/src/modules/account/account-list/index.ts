import * as angular from 'angular'
import './account-list.scss'
import template from './account-list.html'
import { AccountListController } from './account-list'
import { AccountService } from '../services/account-service'

const accountListModule = angular
    .module('app.account.list', [])
    .service('accountService', AccountService)
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.account.list', {
                url: '/list',
                templateUrl: template,
                controller: AccountListController,
                controllerAs: '$ctrl',
                resolve: {
                    accounts: ['accountService', (accountService) => accountService.getAccounts().then(response => response.data)]
                }
            })
    }])
    .name

export { accountListModule }