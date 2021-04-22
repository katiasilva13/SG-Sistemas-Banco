export default interface User {
  id?: string,
  name?: string,
  phoneNumber?: string,

  // firstName?: string,
  // lastName?: string,
  // email?: string,
  // user?: string,
  // password?: string,
  // isAdmin?: boolean
  accounts?: Account[],
}