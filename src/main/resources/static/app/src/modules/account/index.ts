import * as angular from 'angular'
import {AccountService} from './services/account-service'
import 'angular-input-masks'


// import accountFormTemplate from './account-form/account-form.html'

// import AccountFormController from './account-form/account-form'
import {accountListModule} from "./account-list";
import {accountDetailsModule} from "./account-details";
import { accountFormModule } from './account-form';

const accountModule = angular.module('app.account', [

    accountDetailsModule,
    accountListModule,
    accountFormModule,
    'ui.utils.masks',
])
  .service('accountService', AccountService)
  .config(['$stateProvider', ($stateProvider) => {
    $stateProvider
      .state('app.account', {
        url: '/accounts',
        abstract: true,
      })
  }])
    .name
export {accountModule}