import {AccountService} from '../services/account-service'
import './account-details.scss'
import User from "../../user/model/user";
import Account from "../model/account";

class AccountDetailsController {
    constructor(
        public $state,
        public accountService: AccountService,
        public account,
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
}

AccountDetailsController['$inject'] = [
    '$state',
    'accountService',
    'account',
]

export {AccountDetailsController};