import {AccountService} from '../services/account-service'
import './account-details.scss'

class AccountDetailsController {
    constructor(
        public $state,
        public accountService: AccountService,
        public account,
    ) {}

}

AccountDetailsController['$inject'] = [
    '$state',
    'accountService',
    'account',
]

export {AccountDetailsController};