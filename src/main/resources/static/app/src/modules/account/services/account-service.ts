import UserService from "../../auth/services/user-service";
import Account from "../model/account";

class AccountService {
  constructor(
    public userService: UserService
  ) {}

  getAccount = (id: string): Account => {
    if (!id) return null
    const user = this.userService.getUser()
    return user?.accounts?.find((account) => account.id == id)
  }
}

AccountService['$inject'] = [
  'userService'
]

export default AccountService