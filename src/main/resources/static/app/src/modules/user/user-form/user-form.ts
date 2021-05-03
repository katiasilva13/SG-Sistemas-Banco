import {UserService} from '../services/user-service'
import './user-form.scss'
import User from '../model/user'

class UserFormController {
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

UserFormController['$inject'] = [
  '$state',
  'userService',
]

export {UserFormController};