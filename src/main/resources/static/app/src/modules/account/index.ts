import * as angular from 'angular'
import accountCreateTemplate from './account-create/account-create.html'
import accountManageTemplate from './account-manage/account-manage.html'
import AccountCreateController from './account-create/account-create'
import AccountManageController from './account-manage/account-manage'
import AccountService from './services/account-service'


import accountsTemplate from './accounts/accounts.html'
// import accountDetailsTemplate from './account-details/account-details.html'
// import accountRegisterTemplate from './account-register/account-register.html'

// import AccountRegisterController from './account-register/account-register'
// import AccountDetailsController from './account-details/account-details'
import AccountsController from './accounts/accounts'

const accountModule = angular.module('app.account', [])
  .service('accountService', AccountService)
  .config(['$stateProvider', ($stateProvider) => {
    // console.log($routeParams)
    $stateProvider
      .state('app.account', {
        url: '^/account',
        abstract: true,
      })
      // .state('app.account.create', {
      //   url: '/create',
      //   templateUrl: accountCreateTemplate,
      //   controller: AccountCreateController,
      //   controllerAs: '$ctrl',
      // })
      // .state('app.account.manage', {
      //   url: '/:id',
      //   templateUrl: accountManageTemplate,
      //   controller: AccountManageController,
      //   controllerAs: '$ctrl',
      //   resolve: {
      //     account: ['$stateParams', 'accountService', ($stateParams, accountService) => accountService.getAccount($stateParams.id)]
      //   }
      // })


      .state('app.getAccounts', {
        url: '/accounts',
        templateUrl: accountsTemplate,
        controller: AccountsController,
        controllerAs: '$ctrl',
        resolve: {
          accounts: ['accountService', (accountService) => accountService.getAccounts().then(response => response.data)]
          }
    })
    // .state('app.details', {
    //     url: '/users/:id',
    //     params: {
    //         id: null
    //     },
    //     templateUrl: userDetailsTemplate,
    //     controller: UserDetailsController,
    //     controllerAs: '$ctrl',  
    //     resolve: {
    //         user: ['$stateParams', 'userService', ($stateParams, userService) => 
    //             userService.getById($stateParams.id).then(response => response.data)]
    //       }
    // })
    // .state('app.register', {
    //     url: '/users/add-user/:type',
    //     templateUrl: userRegisterTemplate,
    //     controller: UserRegisterController,
    //     controllerAs: '$ctrl',  
    // })



  }])
export default accountModule