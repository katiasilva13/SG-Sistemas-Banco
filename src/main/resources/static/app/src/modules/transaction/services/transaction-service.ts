import {UserService} from "../../user/services/user-service";
import {AccountService} from "../../account/services/account-service";
import Transaction from "../model/transaction";
import User from "../../user/model/user";
import Account from "../../account/model/account";
import * as angular from "angular";
import {forEach} from "@uirouter/angularjs";

class TransactionService {
  private url: string = 'http://localhost:8080/transacoes'
  constructor(
    public $http,
    // public userService: UserService
  ) { }

  addTransaction = async (transaction): Promise<Transaction> => {
    return await this.$http.post(this.url, transaction)
  }

  getTransactions = async (): Promise<Transaction[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<Transaction> => {
    return await this.$http.get(this.url + `/${id}`)
  }


}
TransactionService['$inject'] = [
  '$http',
  // 'userService'
]

export {TransactionService}