import {AccountService} from '../services/account-service'
import './account-details.scss'
import User from "../../user/model/user";

class AccountDetailsController {

    // public user
    constructor(
        public $state,
        public accountService: AccountService,
        public account,
        // public user?: User
    ) {}

    // onInit(){
    //
    //     console.log("this.account")
    //     // account = ['$stateParams', 'accountService', ($stateParams, accountService) =>
    //     //         accountService.getById($stateParams.id).then(response => response.data)];
    //
    //     this.user = function()  {
    //         console.log(this.account.data.name)
    //     }
    //     // user: ['$stateParams', 'accountService', ($stateParams, accountService) =>
    //     //     accountService.getByPerson(this.account.personId).then(response => response.data)];
    // }

}

AccountDetailsController['$inject'] = [
    '$state',
    'accountService',
    'account',
    // 'user',
]

export {AccountDetailsController};