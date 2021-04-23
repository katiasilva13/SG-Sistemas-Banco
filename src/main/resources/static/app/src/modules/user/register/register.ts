import UserService from '../services/user-service'
import './register.scss'

class RegisterController {
  constructor(
    public $state,
    public userService: UserService,
    public user,
  ) {}

  //TODO criar addUser()
}

RegisterController['$inject'] = [
  '$state',
  'userService',
  'user', 
]

export default RegisterController;