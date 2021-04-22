import UserService from '../services/user-service'
import './users.scss'

class UsersController {
  // private credentials: {user, password}
  constructor(
    public $state,
    public userService: UserService
  ) {}

  // login = () => {
  //   const user = this.userService.authUser(this.credentials)
  //   if (user.accounts[0]) {
  //     this.$state.go('app.account.manage', { id: user.accounts[0].id })
  //   } else {
  //     this.$state.go('app.home')
  //   }
  // }
}

UsersController['$inject'] = [
  '$state',
  'userService'
]

export default UsersController;