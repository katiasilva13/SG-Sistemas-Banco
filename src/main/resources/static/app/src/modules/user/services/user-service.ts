import * as angular from 'angular'
import User from "../model/user";

class UserService {
  private url: string = 'http://localhost:8080/usuarios'

  constructor(
    public $http,
  ) { }

  addUser = async (user): Promise<User> => {
    return await this.$http.post(this.url, user)
  }

  getUsers = async (): Promise<User[]> => {
    return await this.$http.get(this.url)
  }

  getById = async (id): Promise<User> => {
    if (id == null) return null;
    return await this.$http.get(this.url + `/${id}`)
  }

  getUserByNameAndDoc = async (user): Promise<User> => {
    console.log("user ", user)
    return await this.$http.post(this.url + `/buscar-dados`, user);
  }
}

UserService['$inject'] = [
  '$http',
]

export { UserService }