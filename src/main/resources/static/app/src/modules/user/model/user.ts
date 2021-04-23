export default interface User {
  id?: string,
  name?: string,
  phoneNumber?: string,
  companyName?: string,
  cnpj?: string,
  cpf?: string,
  rg?: string,

  //TODO address

  accounts?: Account[],//TODO alter account
}