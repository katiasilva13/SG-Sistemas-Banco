import {UserService} from "../../user/services/user-service";
import Account from "../model/account";
import User from "../../user/model/user";
import * as angular from "angular";
import {forEach} from "@uirouter/angularjs";

class AccountService {
  private url: string = 'http://localhost:8080/contas'
  constructor(
    public $http,
    // public userService: UserService
  ) { }

  addAccount = async (account): Promise<Account> => {
    return await this.$http.post(this.url, account)
  }

  getAccounts = async (): Promise<Account[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<Account> => {
    return await this.$http.get(this.url + `/${id}`)
  }

  getAccountByCode = async (transaction): Promise<User> => {
    console.log("transaction ", transaction)
    console.log("transaction.sourceAccountCode ", transaction.sourceAccountCode)
    var account: any = {};
    console.log("account ", account);
    account.accountCode = transaction.sourceAccountCode;
    console.log("account.accountCode ", account.accountCode);
    console.log("account ", account)
    return await this.$http.post(this.url + `/buscar-dados`, account);
  }

}
AccountService['$inject'] = [
  '$http',
  // 'userService'
]

export {AccountService}