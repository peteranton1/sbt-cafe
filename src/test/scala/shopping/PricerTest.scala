package shopping

import org.scalatest.FunSuite

import java.math.BigDecimal

class PricerTest extends FunSuite {

  val applePrice = new BigDecimal("0.60")
  val orangePrice = new BigDecimal("0.25")
  val APPLE: Item = Item("Apple", applePrice)
  val ORANGE: Item = Item("Orange", orangePrice)

  test("should sum 1 apple") {
    val input = List(APPLE.price)
    val expected = new BigDecimal("0.60")
    val actual = Pricer.sum(input)
    assert(actual == expected)
  }

  test("should sum 4 apple 3 orange") {
    val input = List(APPLE.price, APPLE.price,
      APPLE.price, ORANGE.price, ORANGE.price)
    val expected = new BigDecimal("2.30")
    val actual = Pricer.sum(input)
    assert(actual == expected)
  }

  test("should filter 1 apple 1 orange APPLE") {
    val input = List(APPLE, ORANGE)
    val expected = List(APPLE.price)
    val actual = Pricer.filter(APPLE.name, input)
    assert(actual == expected)
  }

  test("should filter 1 apple 1 orange ORANGE") {
    val input = List(APPLE, ORANGE)
    val expected = List(ORANGE.price)
    val actual = Pricer.filter(ORANGE.name, input)
    assert(actual == expected)
  }

  test("should filter 2 apple 3 orange") {
    val input = List(APPLE, APPLE, ORANGE, ORANGE, ORANGE)
    val expected = List(APPLE.price, APPLE.price)
    val actual = Pricer.filter(APPLE.name, input)
    assert(actual == expected)
  }

}
