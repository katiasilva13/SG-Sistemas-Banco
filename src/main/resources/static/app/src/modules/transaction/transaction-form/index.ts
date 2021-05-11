import * as angular from 'angular'
import './transaction-form.scss'
import template from './transaction-form.html'
import { TransactionFormController } from './transaction-form'

const transactionFormModule = angular
    .module('app.transaction.form', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.transaction.form', {
                url: '/form/:type',
                params: {
                    type: null

                },
                templateUrl: template,
                controller: TransactionFormController,
                controllerAs: '$ctrl',
            })
    }])
    .name

export { transactionFormModule }