import { AccountService } from '../services/account-service'
import { UserService } from '../../user/services/user-service'
import './account-form.scss'
import Account from '../model/account'

class AccountFormController {
    public account: Account
    constructor(
        public $state,
        public accountService: AccountService,
        public userService: UserService,
    ) { }

    addAccount = function (account) {
        const savedAccount = this.accountService.addAccount(account).then(() => {
            if (savedAccount != null) {
                this.$state.go('app.account.list')
            } else this.$state.reloadRoute();
        })
    };

    // personIdIsEmpty = () => {
    //     return location.href.includes('^//')
    // };

    isCARoute = () => {
        return location.href.includes('/ca')
    };

    isSARoute = () => {
        return location.href.includes('/sa')
    };

    reloadRoute = () => {
        location.reload();
    }

    saveAccount = async function (user, type: string) {
        const savedUser = await this.userService.getUserByNameAndDoc(user)
            .then(res => res.data);
        if (savedUser != null) {
            var account: any = {};
            account.personId = savedUser.id;
            account.accountType = (type == "ca") ? '1' : '2';   
            this.addAccount(account);
        } else this.$state.reloadRoute();
    };

    setAccountData = function (user,  type) {
        var account: any = {};
        account.personId = user.id;;
        account.accountType = (type == "ca") ? '1' : '2';  
        this.addAccount(account);        
    }

}

AccountFormController['$inject'] = [
    '$state',
    'accountService',
    'userService',
    // 'user',
]

export { AccountFormController };