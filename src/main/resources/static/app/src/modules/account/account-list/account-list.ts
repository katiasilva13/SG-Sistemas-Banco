import {AccountService} from '../services/account-service'
import './account-list.scss'
import Account from "../model/account";

class AccountListController {
  constructor(
    public $state,
    public accountService: AccountService,
    public accounts
  ) {}

  getAccountTypeLabel = (account: Account): string => {
    switch (account.accountType) {
      case 'CHECKING_ACCOUNT':
        return 'Conta Corrente'
      case 'SAVINGS_ACCOUNT':
        return 'Conta Poupança'
      default:
        return 'N/A'
    }
  }

  back() {
		history.back()
	}

}

AccountListController['$inject'] = [
  '$state',
  'accountService',
  'accounts'
]

export {AccountListController};