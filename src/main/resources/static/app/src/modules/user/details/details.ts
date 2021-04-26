import UserService from '../services/user-service'
import './details.scss'

class DetailsController {
  constructor(
    public $state,
    public userService: UserService,
    public user,
  ) {}

}

DetailsController['$inject'] = [
  '$state',
  'userService',
  'user', 
]

export default DetailsController;