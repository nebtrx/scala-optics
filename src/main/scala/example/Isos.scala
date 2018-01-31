package example

import monocle.Iso
import Models._
import monocle.macros.GenIso


object Isos extends App {

  val personToTuple: Iso[Person, (String, Int)] = Iso[Person, (String, Int)](p => (p.name, p.age)){case (name, age) => Person(name, age)}

  val tuple: (String, Int) = personToTuple.get(Person("Zoe", 25))
  // res0: (String, Int) = (Zoe,25)

  println(s"ISO: $tuple")

  val person: Person = personToTuple.reverseGet(("Zoe", 25))
  // res1: Person = Person(Zoe,25)
  println(s"Reverse ISO: $person")

  val directTupleMapping = GenIso.fields[Person].get(Person("John", 42))

  println(s"Automapping with GenIso macros: $directTupleMapping")
}
