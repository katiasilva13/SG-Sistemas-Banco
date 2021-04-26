import AccountService from '../services/account-service'
import './accounts.scss'

class AccountsController {
  constructor(
    public $state,
    public accountService: AccountService,
    public accounts
  ) {}

 
}

AccountsController['$inject'] = [
  '$state',
  'AccountService',
  'accounts'
]

export default AccountsController;