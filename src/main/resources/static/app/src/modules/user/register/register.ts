import UserService from '../services/user-service'
import './register.scss'
import User from '../model/user'

class RegisterController {
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

RegisterController['$inject'] = [
  '$state',
  'userService',
]

export default RegisterController;