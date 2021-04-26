import Transaction from "../../transaction/model/transaction";

export default interface Account {
  id?: string,
  personId?: number,
  agency?: string,
  accountNumber?: string,
  createdAt?: string,
  balance?: number,
  incoming?: number,
  history?: Transaction[]

  // branch?: string,
  // accountCode?: string,
  // accountType?: string,
  // balance?: number,

  // overdraftLimit: number,
  // overdraftAvailable: number,
  // interestRate: number,
  // interest: number,
  // interestDay: Date,

  // savingsRate: number,
  // savingsIncome: number,
  // invested: number,
  // investmentDay: Date,

  transations?: Transaction[]//?
}