import {UserService} from '../services/user-service'
import './user-list.scss'
import User from '../model/user'

class UserListController {
  constructor(
    public $state,
    public userService: UserService,
    public users
  ) {}

 
}

UserListController['$inject'] = [
  '$state',
  'userService',
  'users'
]

export {UserListController};