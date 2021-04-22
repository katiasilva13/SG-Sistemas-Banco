import './navbar.scss'
import template from './navbar.html'

class NavBarController {
    constructor(
        public $location,
        public $window,
        // public userService: UserService,
    ) {}
}

NavBarController['$inject'] = [
    '$location',
    '$window',
    // 'userService'
]

const navBar = {
    controller: NavBarController,
    controllerAs: '$ctrl',
    templateUrl: template
}

export default navBar;