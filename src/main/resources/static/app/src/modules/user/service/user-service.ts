// import UserFactory from "../model/factory/user-factory";
import User from "../model/user";

class UserService {
  private user: User
  private url: string = 'http://localhost:8080/usuarios'

  constructor(
    public $http
    ) {}

  getUser = async (id: string): Promise<User> => {
    // if (this.user) return this.user
    // this.user = JSON.parse(sessionStorage.user ?? null)
    return await this.$http.get(this.url+`/${id}`).then(data => data.response)
  }

//   getUser = (): User => {
//     if (this.user) return this.user
//     this.user = JSON.parse(sessionStorage.user ?? null)
//     return this.user
//   }

//   authUser = ({user, password}): User => {
//     this.user = this.userFactory.create({ user, password, isAdmin: user == 'admin' })
//     sessionStorage.user = JSON.stringify(this.user)
//     return this.user
//   }

//   logout = () => {
//     delete this.user
//     delete sessionStorage.user
//   }
}

UserService['$inject'] = [
    '$http',
//   'userFactory'
]

export default UserService