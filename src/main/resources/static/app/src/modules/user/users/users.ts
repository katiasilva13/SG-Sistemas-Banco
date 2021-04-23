import UserService from '../services/user-service'
import './users.scss'

class UsersController {
  constructor(
    public $state,
    public userService: UserService,
    public users
  ) {}

 
}

UsersController['$inject'] = [
  '$state',
  'userService',
  'users'
]

export default UsersController;