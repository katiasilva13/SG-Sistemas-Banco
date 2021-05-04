import {UserService} from '../services/user-service'
import './user-list.scss'
import User from '../model/user'

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

export {UsersController};