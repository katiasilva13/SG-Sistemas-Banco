import UserService from '../services/user-service'
import './user-register.scss'
import User from '../model/user'

class UserRegisterController {
  public user: User
  constructor(
    public $state,
    public userService: UserService,
  ) { }

  addUser = function (user) {
    const savedUser = this.userService.addUser(user).then(() => {
      if (savedUser != null) {
        this.$state.go('app.getUsers')
      } else this.$state.reloadRoute();
    })
  };


  isPfRoute = () => {
    return location.href.includes('/pf')
  };

  isPjRoute = () => {
    return location.href.includes('/pj')
  };

  reloadRoute = () => {
    location.reload();
  }

}

UserRegisterController['$inject'] = [
  '$state',
  'userService',
]

export default UserRegisterController;