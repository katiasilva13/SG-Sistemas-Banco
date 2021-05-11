import { AccountService } from '../../account/services/account-service'
import { TransactionService } from '../services/transaction-service'
import './transaction-form.scss'
import Transaction from '../model/transaction'

class TransactionFormController {
    public transaction: Transaction
    public account: Account
    constructor(
        public $state,
        public accountService: AccountService,
        public transactionService: TransactionService,
    ) { }

    addTransaction = function (transaction) {
        const savedTransaction = this.transactionService.addTransaction(transaction).then(() => {
            if (savedTransaction != null) {
                this.$state.go('app.transaction.list')
            } else this.$state.reloadRoute();
        })
    };

    isTransferRoute = () => {
        return location.href.includes('/transfer')
    };

    isDepositRoute = () => {
        return location.href.includes('/deposit')
    };

    isWithdrawalRoute = () => {
        return location.href.includes('/withdrawal')
    };

    reloadRoute = () => {
        location.reload();
    }
    
    saveTransaction = async function (transaction, type) {
        this.account = await this.accountService.getAccountByCode(transaction)
            .then(res => res.data);
        if (this.account != null) {
            transaction.sourceAccountId = this.account.id;
            console.log("t.form line 44",transaction, "type", type)
            switch (type) {
                case "deposit":
                    transaction.transactionType='3'                 
                    break;
                case "transfer":
                    transaction.transactionType='4'                 
                    break;
                case "withdrawal":
                    transaction.transactionType='5'                 
                    break;
            }
            console.log("t.form line 56",transaction)
            this.addTransaction(transaction);
        } else this.$state.reloadRoute();
    };

    // setAccountData = function (user,  type) {
    //     var account: any = {};
    //     account.personId = user.id;;
    //     account.accountType = (type == "ca") ? '1' : '2';  
    //     this.addAccount(account);        
    // }

}

TransactionFormController['$inject'] = [
    '$state',
    'accountService',
    'transactionService',
    // 'transaction',
]

export { TransactionFormController };