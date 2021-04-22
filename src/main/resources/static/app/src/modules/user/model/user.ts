
export default interface User {
//   id?: string,
//   firstName?: string,
//   lastName?: string,
//   email?: string,
//   user?: string,
//   password?: string,
//   isAdmin?: boolean
//   accounts?: Account[],

    id?: bigint,
    name?: string,
    phoneNumber?: string,
    rg?: string,
    cpf?: string,
    cnpj?: string,
    companyName?: string,
    // address?: Address, //ou colocar cada atributo?
    accounts?: Account[],
  
}