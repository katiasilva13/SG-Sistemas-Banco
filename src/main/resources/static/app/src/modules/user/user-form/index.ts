import * as angular from 'angular'
import './user-form.scss'
import template from './user-form.html'
import { UserFormController } from './user-form'

const userFormModule = angular
    .module('app.user.form', [])
    .config(['$stateProvider', ($stateProvider) => {
        $stateProvider
            .state('app.user.form', {
                url: '/form',
                templateUrl: template,
                controller: UserFormController,
                controllerAs: '$ctrl'
            })
    }])
    .name

export { userFormModule }
