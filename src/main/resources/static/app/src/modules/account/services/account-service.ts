import UserService from "../../auth/services/user-service";
import Account from "../model/account";

class AccountService {
  private url: string = 'http://localhost:8080/contas'
  constructor(
    public $http,
    public userService: UserService
  ) { }

  // getAccount = (id: string): Account => {
  //   if (!id) return null
  //   const user = this.userService.getUser()
  //   return user?.accounts?.find((account) => account.id == id)
  // }


  addAccount = async (account): Promise<Account> => {
    return await this.$http.post(this.url, account)
  }

  getAccounts = async (): Promise<Account[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<Account> => {
    return await this.$http.get(this.url + `/${id}`)
  }

  // getByPerson = async (id): Promise<Account> => {
  //   return await this.$http.get(this.url + `/usuarios/${id}`)
  // }
}
AccountService['$inject'] = [
  '$http',
  'userService'
]

export default AccountService