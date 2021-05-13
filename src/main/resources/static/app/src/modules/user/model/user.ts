import Account from '../../account/model/account'
import Address from '../model/address'

export default interface User {
  id?: string,
  name?: string,
  phoneNumber?: string,
  companyName?: string,
  cnpj?: string,
  cpf?: string,
  rg?: string,

  accounts?: Account[],

  address?: Address,

  uf?: string,
  cep?: string,
  number?: string,
  street?: string,
  neighborhood?: string,
  city?: string


  doc?: string,
  type?:  string,
  personId?: string, 
}