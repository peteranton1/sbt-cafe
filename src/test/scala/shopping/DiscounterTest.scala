package shopping

import org.scalatest.FunSuite

import java.math.BigDecimal

class DiscounterTest extends FunSuite {

  val applePrice = new BigDecimal("0.60")
  val orangePrice = new BigDecimal("0.25")
  val APPLE: Item = Item("Apple", applePrice)
  val ORANGE: Item = Item("Orange", orangePrice)

  test("should bogof 1 apple") {
    val input = List(APPLE)
    val expected = BigDecimal.ZERO
    val actual = Discounter.discountBogof(APPLE.name, input)
    assert(actual == expected)
  }

  test("should bogof 2 apple") {
    val input = List(APPLE, APPLE)
    val expected = new BigDecimal("0.60")
    val actual = Discounter.discountBogof(APPLE.name, input)
    assert(actual == expected)
  }

  test("should bogof 3 apple") {
    val input = List(APPLE, APPLE, APPLE)
    val expected = new BigDecimal("0.60")
    val actual = Discounter.discountBogof(APPLE.name, input)
    assert(actual == expected)
  }

  test("should bogof 4 apple") {
    val input = List(APPLE, APPLE, APPLE, APPLE)
    val expected = new BigDecimal("1.20")
    val actual = Discounter.discountBogof(APPLE.name, input)
    assert(actual == expected)
  }

  test("should bogof 5 apple") {
    val input = List(APPLE, APPLE, APPLE, APPLE, APPLE)
    val expected = new BigDecimal("1.20")
    val actual = Discounter.discountBogof(APPLE.name, input)
    assert(actual == expected)
  }

  test("should 3for2 1 orange") {
    val input = List(ORANGE)
    val expected = BigDecimal.ZERO
    val actual = Discounter.discount3for2(ORANGE.name, input)
    assert(actual == expected)
  }

  test("should 3for2 2 orange") {
    val input = List(ORANGE, ORANGE)
    val expected = BigDecimal.ZERO
    val actual = Discounter.discount3for2(ORANGE.name, input)
    assert(actual == expected)
  }

  test("should 3for2 3 orange") {
    val input = List(ORANGE, ORANGE, ORANGE)
    val expected = new BigDecimal("0.25")
    val actual = Discounter.discount3for2(ORANGE.name, input)
    assert(actual == expected)
  }

  test("should 3for2 4 orange") {
    val input = List(ORANGE, ORANGE, ORANGE, ORANGE)
    val expected = new BigDecimal("0.25")
    val actual = Discounter.discount3for2(ORANGE.name, input)
    assert(actual == expected)
  }

  test("should 3for2 5 orange") {
    val input = List(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE)
    val expected = new BigDecimal("0.25")
    val actual = Discounter.discount3for2(ORANGE.name, input)
    assert(actual == expected)
  }
}
