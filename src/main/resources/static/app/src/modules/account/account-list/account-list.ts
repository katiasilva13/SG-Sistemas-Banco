import {AccountService} from '../services/account-service'
import './account-list.scss'

class AccountListController {
  constructor(
    public $state,
    public accountService: AccountService,
    public accounts
  ) {}


}

AccountListController['$inject'] = [
  '$state',
  'accountService',
  'accounts'
]

export {AccountListController};