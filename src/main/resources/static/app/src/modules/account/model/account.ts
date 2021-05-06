import Transaction from "../../transaction/model/transaction";
import User from "../../user/model/user";

export default interface Account {
  id?: number,
  personId?: number,
  person?: User,
  // agency?: string,
  // accountNumber?: string,
  // createdAt?: string,
  // balance?: number,
  // incoming?: number,
  // history?: Transaction[]

  branch?: string,
  accountCode?: string,
  accountType?: string,
  balance?: number,

  overdraftLimit: number,
  overdraftAvailable: number,
  interestRate: number,
  interest: number,
  interestDay: Date,

  savingsRate: number,
  savingsIncome: number,
  invested: number,
  investmentDay: Date,

  user?: User,

  transations?: Transaction[]//?
}