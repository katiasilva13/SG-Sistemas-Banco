// import { TransactionMethod } from '../model/enum/transaction-method'
import { TransactionType } from '../model/enum/transaction-type'
import Account from "../../account/model/account";

export default interface Transaction {
  id?: string,
  value?: number,

  sourceId?: string,
  destinationId?: string,
  // transactionMethod?: TransactionMethod,
  // transactionType?: TransactionType,
  transactionDate?: Date,
  parent?: Transaction,

  transactionType?: any,
  timestamp?: Date,
  sourceAccountId?: string,
  destinationAccountId?: string,
  transferId?: string,
  
  sourceAccountCode?: string,
  destinationAccountCode?: string,
  destinationAccountBranch?: string,


  sourceAccount?: Account,
  destinationAccount?: Account,

  type?: string,
}