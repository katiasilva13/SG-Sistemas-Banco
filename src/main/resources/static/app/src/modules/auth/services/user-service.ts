import UserFactory from "../model/factory/user-factory";
import User from "../model/User";

class UserService {
  private user: User

  constructor(
    public userFactory: UserFactory
  ) {}

  getUser = (): User => {
    if (this.user) return this.user
    this.user = JSON.parse(sessionStorage.user ?? null)
    return this.user
  }

  authUser = ({user, password}): User => {
    this.user = this.userFactory.create({ user, password, isAdmin: user == 'admin' })
    sessionStorage.user = JSON.stringify(this.user)
    return this.user
  }

  logout = () => {
    delete this.user
    delete sessionStorage.user
  }
}

UserService['$inject'] = [
  'userFactory'
]

export default UserService