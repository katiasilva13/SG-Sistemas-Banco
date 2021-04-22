
class AccountCreateController {
  constructor(
    public $scope,
    public $state,
    public $http
  ) {}
}

AccountCreateController['$inject'] = [
  '$scope',
  '$state',
  '$http'
]

export default AccountCreateController;