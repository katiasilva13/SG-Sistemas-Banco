import UserService from '../services/user-service'
import './register.scss'
import User from './model/user'

class RegisterController {
  public user: User
  private type: string
  constructor(
    // public $location,
    // public $window,
    // public $route,
    public $state,
    public userService: UserService,
    // public user,
  ) { }


  //TODO criar addUser()
  addUser = function (user) {
    console.log("register.ts line 18")
    const savedUser = this.userService.addUser(user)
    if (savedUser != null) {
      this.$state.go('app.getUsers')
    } else this.$state.reloadRoute();
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
  // '$route'
  // '$location',
  // '$window',
  // 'user', 
]

export default RegisterController;