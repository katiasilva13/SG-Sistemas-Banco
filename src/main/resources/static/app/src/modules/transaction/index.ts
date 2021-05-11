import * as angular from 'angular'
import {TransactionService} from './services/transaction-service'
import 'angular-input-masks'

import {transactionListModule} from "./transaction-list";
// import {accountDetailsModule} from "./account-details";
// import { accountFormModule } from './account-form';

const transactionModule = angular.module('app.transaction', [
    transactionListModule,
    // transactionDetailsModule,
    // transactionFormModule,
    'ui.utils.masks',
])
  .service('transactionService', TransactionService)
  .config(['$stateProvider', ($stateProvider) => {
    $stateProvider
      .state('app.transaction', {
        url: '/transactions',
        abstract: true,
      })
  }])
    .name
export {transactionModule}