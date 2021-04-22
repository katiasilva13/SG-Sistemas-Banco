export default interface Factory {
  create(params?: object): Object,
  createMany(params?: object, count?: number): Object[],
  make(params?: object): Object,
}