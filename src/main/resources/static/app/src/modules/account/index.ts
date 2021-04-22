import * as angular from 'angular'
import accountCreateTemplate from './account-create/account-create.html'
import accountManageTemplate from './account-manage/account-manage.html'
import AccountCreateController from './account-create/account-create'
import AccountManageController from './account-manage/account-manage'
import AccountService from './services/account-service'

const accountModule = angular.module('app.account', [])
  .service('accountService', AccountService)
  .config(['$stateProvider', ($stateProvider) => {
    // console.log($routeParams)
    $stateProvider
      .state('app.account', {
        url: '^/account',
        abstract: true,
      })
      .state('app.account.create', {
        url: '/create',
        templateUrl: accountCreateTemplate,
        controller: AccountCreateController,
        controllerAs: '$ctrl',
      })
      .state('app.account.manage', {
        url: '/:id',
        templateUrl: accountManageTemplate,
        controller: AccountManageController,
        controllerAs: '$ctrl',
        resolve: {
          account: ['$stateParams', 'accountService', ($stateParams, accountService) => accountService.getAccount($stateParams.id)]
        }
      })
  }])
export default accountModule