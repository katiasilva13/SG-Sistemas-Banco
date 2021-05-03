import * as angular from 'angular'

class AppController {
  constructor(
    public $scope
  ) {}

  $onInit() {
    this.$scope.message = "Hello World!";
    console.log("Hello World!");
  }
}

AppController['$inject'] = [
  '$scope'
]

export { AppController }