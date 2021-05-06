import {UserService} from "../../user/services/user-service";
import Account from "../model/account";
import User from "../../user/model/user";
import * as angular from "angular";
import {forEach} from "@uirouter/angularjs";

class AccountService {
  private url: string = 'http://localhost:8080/contas'
  constructor(
    public $http,
    public userService: UserService
  ) { }

  // getAccount = (id: string): Account => {
  //   if (!id) return null
  //   const user = this.userService.getUser()
  //   return user?.accounts?.find((account) => account.id == id)
  // }

  addAccount = async (account): Promise<Account> => {
    return await this.$http.post(this.url, account)
  }

  getAccounts = async (): Promise<Account[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<Account> => {
    return await this.$http.get(this.url + `/${id}`)
  }

  // getByPerson = async (id): Promise<User> => {
  //   return await this.userService.getById(id)
  // }
  // getPersonByAccount = async (accountID): Promise<User>  => {
  //   var user: User;
  //   const users = await this.userService.getUsers();

  //   for (const item in users) {
  //     if (Object.prototype.hasOwnProperty.call(users, item)) {
  //       // const element = users[item];
  //       console.log(users[item]);
    
  //       // if((element.accounts[0].id == accountID) || (element.accounts[1].id == accountID))
  //       //   user=  element;
    
  //     }
  // }
  //   console.log(accountID);
  //   console.log(users);
  //   console.log(user);

  //     return user = await this.userService.getById(89);


  //   // (await users).forEach(element => {
  //   //   if((element.accounts[0].id == accountID) || (element.accounts[1].id == accountID))
  //   //   console.log(element);
  //   //   return  element;
  //   // });


  // }



}
AccountService['$inject'] = [
  '$http',
  'userService'
]

export {AccountService}