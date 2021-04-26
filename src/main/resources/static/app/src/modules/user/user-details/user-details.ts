import UserService from '../services/user-service'
import './user-details.scss'

class UserDetailsController {
  constructor(
    public $state,
    public userService: UserService,
    public user,
  ) {}

}

UserDetailsController['$inject'] = [
  '$state',
  'userService',
  'user', 
]

export default UserDetailsController;