import { TransactionMethod } from '../../transaction/model/enum/transaction-method';
import Transaction from '../../transaction/model/transaction';
import Account from '../model/account';
import './account-manage.scss'

class AccountHomeController {
  constructor(
    public $scope,
    public $state,
    public account?: Account,
  ) {}

  getTransactionMethodLabel = (transaction: Transaction): string => {
    switch (transaction.transactionMethod) {
      case TransactionMethod.DEPOSIT:
        return 'Depósito'
      case TransactionMethod.TRANSFER:
        return 'Transferência'
      case TransactionMethod.WITHDRAW:
        return 'Saque'
      default:
        return 'N/A'
    }
  }
}

AccountHomeController['$inject'] = [
  '$scope',
  '$state',
  'account'
]

export default AccountHomeController;