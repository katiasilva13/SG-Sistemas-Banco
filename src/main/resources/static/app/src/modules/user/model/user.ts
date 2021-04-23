export default interface User {
  id?: string,
  name?: string,
  phoneNumber?: string,
  companyName?: string,
  cnpj?: string,
  cpf?: string,
  rg?: string,

  //TODO checar se é realmente necessario

  //TODO address

  accounts?: Account[],//TODO alter account
}