export default interface User {
  id?: string,
  name?: string,
  phoneNumber?: string,
  companyName?: string,
  cnpj?: string,
  cpf?: string,
  rg?: string,

  //address

  // firstName?: string,
  // lastName?: string,
  // email?: string,
  // user?: string,
  // password?: string,
  // isAdmin?: boolean
  accounts?: Account[],//alter account
}