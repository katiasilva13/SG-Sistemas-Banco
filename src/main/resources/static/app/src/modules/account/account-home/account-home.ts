

class AccountHomeController {
    constructor(
      public $scope,
      public $state,
      public $http
    ) {}
  }
  
  AccountHomeController['$inject'] = [
    '$scope',
    '$state',
    '$http'
  ]
  
  export default AccountHomeController;