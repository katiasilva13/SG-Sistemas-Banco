import * as angular from 'angular'
import {AccountService} from './services/account-service'


// import accountFormTemplate from './account-form/account-form.html'

// import AccountFormController from './account-form/account-form'
import {accountListModule} from "./account-list";
import {accountDetailsModule} from "./account-details";

const accountModule = angular.module('app.account', [

    accountDetailsModule,
    accountListModule,
    'ui.utils.masks',
])
  .service('accountService', AccountService)
  .config(['$stateProvider', ($stateProvider) => {
    // console.log($routeParams)
    $stateProvider
      .state('app.account', {
        url: '/accounts',
        abstract: true,
      })
  }])
    .name
export {accountModule}