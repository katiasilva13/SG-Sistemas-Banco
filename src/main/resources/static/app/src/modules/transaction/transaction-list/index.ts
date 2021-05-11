import * as angular from 'angular'
import './transaction-list.scss'
import template from './transaction-list.html'
import { TransactionListController } from './transaction-list'
import { TransactionService } from '../services/transaction-service'

const transactionListModule = angular
    .module('app.transaction.list', [])
    .service('transactionService', TransactionService)
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.transaction.list', {
                url: '/list',
                templateUrl: template,
                controller: TransactionListController,
                controllerAs: '$ctrl',
                resolve: {
                    transactions: ['transactionService', (transactionService) => transactionService.getTransactions().then(response => response.data)]
                }
            })
    }])
    .name

export { transactionListModule }