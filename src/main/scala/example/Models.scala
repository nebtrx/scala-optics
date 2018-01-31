package example

object Models {
  case class Street(number: Int, name: String)
  case class Address(city: String, street: Street)
  case class Company(name: String, address: Address)
  case class Employee(name: String, company: Company)
  case class Person(name: String, age: Int)
  case class PersonDTO(name: String, age: Int)
}
