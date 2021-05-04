// import * as angular from 'angular'
// import usersTemplate from './users/user-list.html'
// import userDetailsTemplate from './user-details/user-details.html'
// import userRegisterTemplate from './user-register/user-form.html'
//
//
// import UserRegisterController from './user-register/user-register'
// import UserDetailsController from './user-details/user-details'
// import UsersController from './users/users'
// import UserService from './services/user-service'
//
// const userModule = angular.module('app.user', [])
//     .service('userService', UserService)
//     .config(['$stateProvider', ($stateProvider) => {
//         $stateProvider
//             .state('app.getUsers', {
//                 url: '/users',
//                 templateUrl: usersTemplate,
//                 controller: UsersController,
//                 controllerAs: '$ctrl',
//                 resolve: {
//                     users: ['userService', (userService) => userService.getUsers().then(response => response.data)]
//                   }
//             })
//             .state('app.details', {
//                 url: '/users/:id',
//                 params: {
//                     id: null
//                 },
//                 templateUrl: userDetailsTemplate,
//                 controller: UserDetailsController,
//                 controllerAs: '$ctrl',
//                 resolve: {
//                     user: ['$stateParams', 'userService', ($stateParams, userService) =>
//                         userService.getById($stateParams.id).then(response => response.data)]
//                   }
//             })
//             .state('app.register', {
//                 url: '/users/add-user/:type',
//                 templateUrl: userRegisterTemplate,
//                 controller: UserRegisterController,
//                 controllerAs: '$ctrl',
//             })
//     }])

/**/
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
