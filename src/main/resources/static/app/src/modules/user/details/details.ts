import UserService from '../services/user-service'
import './details.scss'

class DetailsController {
    private id: bigint
  constructor(
    public $state,
    public userService: UserService,
    public user
  ) {}

//   login = () => {
//     const user = this.userService.authUser(this.credentials)
//     if (user.accounts[0]) {
//       this.$state.go('app.account.manage', { id: user.accounts[0].id })
//     } else {
//       this.$state.go('app.home')
//     }
//   }

}

DetailsController['$inject'] = [
  '$state',
  'userService',
  'user'
]

export default DetailsController;