import UserService from '../services/user-service'
import './users.scss'

class UsersController {
  // private credentials: {user, password}
  public users
  constructor(
    public $state,
    public userService: UserService,
    
  ) {}

  $onInit() {
   this.userService.getUsers().then(response => {
     this.users = response
   } )
      // this.getUsers().then(response => {
      //   this.users = response;
      //   console.log(response)
      // })
      console.log("teste 123")
    }

    // users = () => {

    // }
// getUsers = () => {
//   this.userService.getUsers().then(response => {
//     response
//     console.log(response)
//   });
    // return users;  

    // console.log(users)
  // }

  // login = () => {
  //   const user = this.userService.authUser(this.credentials)
  //   if (user.accounts[0]) {
  //     this.$state.go('app.account.manage', { id: user.accounts[0].id })
  //   } else {
  //     this.$state.go('app.home')
  //   }
  // }
}

UsersController['$inject'] = [
  '$state',
  'userService',
  // 'users'
]

export default UsersController;