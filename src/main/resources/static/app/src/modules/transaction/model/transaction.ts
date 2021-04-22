import { TransactionMethod } from '../model/enum/transaction-method'
import { TransactionType } from '../model/enum/transaction-type'

export default interface Transaction {
  id?: string,
  sourceId?: string,
  destinationId?: string,
  transactionMethod?: TransactionMethod,
  transactionType?: TransactionType,
  transactionDate?: Date,
  parent?: Transaction,
  value?: number,
}