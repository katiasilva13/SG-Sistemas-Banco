import { stringify } from '@uirouter/core'
import UserService from '../service/user-service'
import './user.scss'

class UserController {
  private id: {id: string}
  constructor(
    public $state,
    public userService: UserService
  ) {}

  getUser = () => {
    const user = this.userService.getUser(stringify(this.id))
    
  }

//   login = () => {
//     const user = this.userService.authUser(this.credentials)
//     if (user.accounts[0]) {
//       this.$state.go('app.account.manage', { id: user.accounts[0].id })
//     } else {
//       this.$state.go('app.home')
//     }
//   }

}


UserController['$inject'] = [
  '$state',
  'userService'
]

export default UserController;