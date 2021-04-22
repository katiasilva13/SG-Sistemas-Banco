// import UserFactory from "../model/factory/user-factory";
import User from "../model/user";

class UserService {
  private users: User[]
  private url: string = 'http://localhost:8080/usuarios'

  constructor(
    public $http,
  ) {}

  // getUsers = async (): Promise<User> => {
  //   console.log("test method"); 
  //   var users = this.$http.get(this.url).then(data => data.resposne)
  //   console.log(users); 
  //   return await users;
  // }

  // $onInit() {
  //   this.getUsers().then(response => {
  //     this.users = response;
  //     console.log(response)
  //   })
  // }
  
  getUsers = async (): Promise<User[]> => {
    return await this.$http.get(this.url)
  }


  // getUser = (): User => {
  //   if (this.user) return this.user
  //   this.user = JSON.parse(sessionStorage.user ?? null)
  //   return this.user
  // }

  // authUser = ({user, password}): User => {
  //   this.user = this.userFactory.create({ user, password, isAdmin: user == 'admin' })
  //   sessionStorage.user = JSON.stringify(this.user)
  //   return this.user
  // }

}

UserService['$inject'] = [
  '$http',
]

export default UserService