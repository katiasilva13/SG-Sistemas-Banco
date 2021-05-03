import * as angular from 'angular'
import User from "../model/user";

class UserService {
  // private users: User[]
  // private user: User
  // private id: bigint
  private url: string = 'http://localhost:8080/usuarios'

  constructor(
    public $http,
  ) {}

  addUser = async (user): Promise<User> => {
    return await this.$http.post(this.url, user)
  }  
  
  getUsers = async (): Promise<User[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<User> => {
    return await this.$http.get(this.url+`/${id}`)
  }

  // getUsers = async (): Promise<User> => {
  //   console.log("test method"); 
  //   var users = this.$http.get(this.url).then(data => data.resposne)
  //   console.log(users); 
  //   return await users;
  // }

  // $onInit() {
  //   this.getUsers().then(response => {
  //     this.users = response;
  //     console.log(response)
  //   })
  // }

}

UserService['$inject'] = [
  '$http',
]

export {UserService}