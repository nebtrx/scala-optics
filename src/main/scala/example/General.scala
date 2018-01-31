package example

import example.Models._
import monocle.Lens
import monocle.macros.GenLens
import monocle.function.Cons.headOption
import monocle.macros.syntax.lens._

object General extends App {

  val company   : Lens[Employee, Company] = GenLens[Employee](_.company)
  val address   : Lens[Company, Address] = GenLens[Company](_.address)
  val street    : Lens[Address, Street] = GenLens[Address](_.street)
  val streetName: Lens[Street, String] = GenLens[Street](_.name)

  val employee = Employee("john", Company("awesome inc", Address("london", Street(23, "high street"))))

  val composedLensesResult = (company composeLens address composeLens street composeLens streetName).modify(_.capitalize)(employee)

  println(s"Composing lenses: $composedLensesResult")

  val composedLensesOptionalLensesResult = (company composeLens address composeLens street composeLens streetName composeOptional headOption).modify(_.toUpper)(employee)

  println(s"Composing lenses with optional lenses for the dealing with the string as a list: $composedLensesOptionalLensesResult")

  val syntaxLensesResult = employee.lens(_.company.address.street.name).modify(_.capitalize)

  println(s"Syntax lenses: $syntaxLensesResult")

  val syntaxLensesOptionalLensesResult = employee.lens(_.company.address.street.name).composeOptional(headOption).modify(_.toUpper)

  println(s"Syntax lenses with optional lenses for the dealing with the string as a list: $syntaxLensesOptionalLensesResult")

}
