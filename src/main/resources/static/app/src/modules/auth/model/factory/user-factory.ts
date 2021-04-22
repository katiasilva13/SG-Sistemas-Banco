import { randexp } from "randexp"
import Factory from "../../../../interfaces/factory"
import AccountFactory from "../../../account/model/factory/account-factory"
import User from "../user"

class UserFactory implements Factory {
  private idRegex: RegExp = /\d{6}/g
  private firstNameRegex: RegExp = /[A-Z][a-z]{3,10}/g
  private lastNameRegex: RegExp = /[A-Z][a-z]{3,10} [A-Z][a-z]{3,10}/g
  private emailRegex: RegExp = /[a-z]{3,8}\.[a-z]{3,8}@gmail\.com/g
  private userRegex: RegExp = /[a-z]{3,8}/g
  private passwordRegex: RegExp = /[a-z]{6,8}/g
  
  create = (params): User => {
    if (!params?.isAdmin && !params?.accounts) {
      params.accounts = new AccountFactory().createMany({}, 1)
    }
    let user: User = {
      id: randexp(this.idRegex),
      firstName: randexp(this.firstNameRegex),
      lastName: randexp(this.lastNameRegex),
      email: randexp(this.emailRegex),
      user: randexp(this.userRegex),
      password: randexp(this.passwordRegex),
      isAdmin: false,
    }
    if (params && typeof params === 'object') {
      user = {...user, ...params}
    }
    return user
  }

  createMany = (params, count = null): User[] => {
    let array: User[] = []
    for (let i in Array.from({length: count}, (value, key) => key)) {
      if (!params?.isAdmin) {
        params.accounts = new AccountFactory().createMany({}, 1)
      }
      let user: User = {
        id: randexp(this.idRegex),
        firstName: randexp(this.firstNameRegex),
        lastName: randexp(this.lastNameRegex),
        email: randexp(this.emailRegex),
        user: randexp(this.userRegex),
        password: randexp(this.passwordRegex),
        isAdmin: false,
      }
      if (params && typeof params === 'object') {
        user = {...user, ...params}
      }
      array.push(user)
    }
    return array
  }

  make = (params = {}): User => {
    return {}
  }
}

export default UserFactory