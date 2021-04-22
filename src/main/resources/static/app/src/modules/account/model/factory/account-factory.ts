import { randexp } from "randexp"
// import { momentRandom } from "moment-random"
import Account from "../account"
import Factory from "../../../../interfaces/factory"
import TransactionFactory from "../../../transaction/model/transaction-factory.ts/transaction-factory"
import { TransactionType } from "../../../transaction/model/enum/transaction-type"

const momentRandom: Function = require('moment-random')

class AccountFactory implements Factory {
  private idRegex: RegExp = /\d{6}/g
  private agencyRegex: RegExp = /\d{5}/g
  private accountNumberRegex: RegExp = /\d{6}/g

  create = (params): Account => {
    let account: Account = {
      id: randexp(this.idRegex),
      agency: randexp(this.agencyRegex),
      accountNumber: randexp(this.accountNumberRegex),
      createdAt: momentRandom(),
      incoming: Math.floor(Math.random() * 5000),
    }
    if (!params?.history) {
      params.history = new TransactionFactory().createMany({hostId: account.id}, (Math.floor(Math.random() * 10)) + 1)
      params.balance = params.history
        .reduce((sum, transaction) => sum + ((transaction.transactionType == TransactionType.CREDIT ? 1 : -1) * transaction.value), 0)
      console.log(params.balance)
    }
    if (params && typeof params === 'object') {
      account = {...account, ...params}
    }
    return account
  }

  createMany(params, count = null): Account[] {
    let array: Account[] = []
    for (let i in Array.from({length: count}, (value, key) => key)) {
      let account: Account = {
        id: randexp(this.idRegex),
        agency: randexp(this.agencyRegex),
        accountNumber: randexp(this.accountNumberRegex),
        createdAt: momentRandom(),
        incoming: Math.floor(Math.random() * 5000),
      }
      params.history = new TransactionFactory().createMany({hostId: account.id}, (Math.floor(Math.random() * 10)) + 1)
      params.balance = params.history
        .reduce((sum, transaction) => sum + ((transaction.transactionType == TransactionType.CREDIT ? 1 : -1) * transaction.value), 0)
      console.log(params.balance)
      if (params && typeof params === 'object') {
        account = {...account, ...params}
      }
      array.push(account)
    }
    return array
  }

  make = (params = {}): Account => {
    return {...params}
  }
}

export default AccountFactory