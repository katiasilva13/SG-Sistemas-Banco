import './nav-bar.scss'
import template from './nav-bar.html'
import UserService from '../../modules/auth/services/user-service';
import User from '../../modules/auth/model/User';
import { textChangeRangeIsUnchanged } from 'typescript';

class NavBarController {
  private user: User
  constructor(
    public $location,
    public $window,
    public userService: UserService,
  ) {}

  $doCheck = () => {
    this.user = this.userService.getUser() ?? {}
  }

  hideButton = () => {
    return this.$location.path().includes('login')
  }

  logout = () => {
    this.userService.logout()
    delete this.user
    this.$window.location.reload()
  }
}

NavBarController['$inject'] = [
  '$location',
  '$window',
  'userService'
]

const navBar = {
  controller: NavBarController,
  controllerAs: '$ctrl',
  templateUrl: template,
  resolve: {
    user: ['userService', (userService) => {
      console.log("nao??")
    }]
  }
}

export default navBar




