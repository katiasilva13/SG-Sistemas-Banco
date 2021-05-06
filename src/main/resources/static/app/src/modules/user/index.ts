import * as angular from 'angular'
import 'angular-input-masks'
import { userDetailsModule } from './user-details'
import { userFormModule } from './user-form'
import { userListModule } from './user-list'
//
import { UserService } from './services/user-service'

const userModule = angular
	.module('app.user', [
		userDetailsModule,
		userFormModule,
		userListModule,
		'ui.utils.masks',
	])
	.service('userService', UserService)
	.config(['$stateProvider', ($stateProvider) => {
		$stateProvider
			.state('app.user', {
				url: '/users',
				abstract: true
			})
	}])
	.name

export { userModule }
