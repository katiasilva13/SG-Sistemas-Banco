import Transaction from "../../transaction/model/transaction";

export default interface Account {
  id?: string,
  agency?: string,
  accountNumber?: string,
  createdAt?: string,
  balance?: number,
  incoming?: number,
  history?: Transaction[]
}