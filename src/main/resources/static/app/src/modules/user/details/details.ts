import UserService from '../services/user-service'
import './details.scss'

class DetailsController {
    // private id: bigint
  constructor(
    public $state,
    public userService: UserService,
    public user,
    // public id
  ) {}

}

DetailsController['$inject'] = [
  '$state',
  'userService',
  'user', 
//   'id'
]

export default DetailsController;