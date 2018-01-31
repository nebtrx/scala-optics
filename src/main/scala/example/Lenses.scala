package example

import monocle.Lens
import monocle.macros.GenLens
import scalaz.std.list._

import scalaz.std.scalaFuture._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits._
import monocle.macros.Lenses

object Lenses extends App{
  case class Address(streetNumber: Int, streetName: String)

  val streetNumber: Lens[Address, Int] = GenLens[Address](_.streetNumber)

  val address = Address(10, "High Street")

  println(s"Arbitrary setting a new val: ${streetNumber.get(address)}")

  println(s"Arbitrary setting a new val: ${streetNumber.set(5)(address)}")

  println(s"In place modifying: ${streetNumber.modify(_ + 1)(address)}")

  def populate(n: Int): List[Int] = if(n > 0) List(n - 1, n + 1) else List(n + 1)

  val populatedStreetNumberWhole = streetNumber.modifyF(populate)(Address(135, "High Street"))

  println(s"Focus on a zoomed value and apply a function that lifts the whole to a context(List): $populatedStreetNumberWhole")

  def updateNumber(n: Int): Future[Int] = Future.successful(n + 1)

  val futurizedStreetNumberWhole = streetNumber.modifyF(updateNumber)(address)

  println(s"Focus on a zoomed value and apply a function that lifts the whole to a context(Future): $futurizedStreetNumberWhole")


  @Lenses("_") case class Point(x: Int, y: Int)
  val point = Point(5, 3)
  val updatedPoint = Point._y.set(0)(point)

  println(s"Using @Lenses annotation: $updatedPoint")
}
