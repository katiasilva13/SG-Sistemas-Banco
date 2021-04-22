import { randexp } from "randexp"
import Factory from "../../../../interfaces/factory"
import Transaction from "../transaction"
import { TransactionMethod } from "../enum/transaction-method"
import { TransactionType } from "../enum/transaction-type"

const momentRandom: Function = require('moment-random')

class TransactionFactory implements Factory {
  private idRegex: RegExp = /\d{6}/g

  private randomMethod = (): TransactionMethod => {
    const rand = Math.floor(Math.random() * Object.keys(TransactionMethod).length)
    return TransactionMethod[Object.keys(TransactionMethod)[rand]]
  }

  private randomType = (): TransactionType => {
    const rand = Math.floor(Math.random() * Object.keys(TransactionType).length)
    return TransactionType[Object.keys(TransactionType)[rand]]
  }

  create(params): Transaction {
    let sourceOrDestination = Math.random() >= 0.5
    let transaction: Transaction = {
      id: randexp(this.idRegex),
      sourceId: params?.hostId && sourceOrDestination ? params.hostId : randexp(this.idRegex),
      destinationId: params?.hostId && !sourceOrDestination ? params.hostId : randexp(this.idRegex),
      transactionMethod: this.randomMethod(),
      transactionType: this.randomType(),
      transactionDate: momentRandom(),
      value: Math.floor(Math.random() * 1000),
    }
    if (params && typeof params === 'object') {
      transaction = {...transaction, ...params}
    }
    return transaction
  }

  createMany(params, count = null): Transaction[] {
    let array: Transaction[] = []
    for (let i in Array.from({length: count}, (value, key) => key)) {
      let sourceOrDestination = Math.random() >= 0.5
      let transaction: Transaction = {
        id: randexp(this.idRegex),
        sourceId: params?.hostId && sourceOrDestination ? params.hostId : randexp(this.idRegex),
        destinationId: params?.hostId && !sourceOrDestination ? params.hostId : randexp(this.idRegex),
        transactionMethod: this.randomMethod(),
        transactionType: this.randomType(),
        transactionDate: momentRandom(),
        value: Math.floor(Math.random() * 1000),
      }
      if (params && typeof params === 'object') {
        transaction = {...transaction, ...params}
      }
      array.push(transaction)
    }
    return array
  }

  make(params = {}): Transaction {
    return {...params}
  }
}

export default TransactionFactory