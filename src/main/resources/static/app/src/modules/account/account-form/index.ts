import * as angular from 'angular'
import './account-form.scss'
import template from './account-form.html'
import { AccountFormController } from './account-form'

const accountFormModule = angular
    .module('app.account.form', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.account.form', {
                url: '/form/:type',
                params: {
                    type: null

                },
                templateUrl: template,
                controller: AccountFormController,
                controllerAs: '$ctrl',
            })
    }])
    .name

export { accountFormModule }