import { TransactionService } from '../services/transaction-service'
import './transaction-list.scss'
import { TransactionType } from '../../transaction/model/enum/transaction-type';
import Account from '../../account/model/account';
import Transaction from '../model/transaction';
import { isBreakOrContinueStatement } from 'typescript';

class TransactionListController {
  constructor(
    public $state,
    public transactionService: TransactionService,
    public transactions
  ) { }


  getTransactionTypeLabel = (transaction: Transaction): string => {
    switch (transaction.transactionType) {
      case TransactionType.DEPOSIT:
        return 'Depósito'
      case TransactionType.TRANSFER:
        return 'Transferência'
      case TransactionType.WITHDRAWAL:
        return 'Saque'
      default:
        return 'N/A'
    }
  }


  back() {
		history.back()
	}
  
}


TransactionListController['$inject'] = [
  '$state',
  'accountService',
  'transactions'
]

export { TransactionListController };
