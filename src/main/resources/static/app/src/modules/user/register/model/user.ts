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
  uf?: string,
  cep?: string,
  number?: string,
  street?: string,
  neighborhood?: string,
  city?: string

  // accounts?: Account[],//TODO alter account
}