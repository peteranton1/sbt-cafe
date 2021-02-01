package shopping

import java.math.BigDecimal
import org.scalatest.FunSuite

class BasketTest extends FunSuite {

  val applePrice = new BigDecimal("0.60")
  val orangePrice = new BigDecimal("0.25")
  val APPLE: Item = Item("Apple",applePrice)
  val ORANGE: Item = Item("Orange",orangePrice)

  test("should make 1 apple") {
    val input = "Apple"
    val expected = List(APPLE)
    val actual = Basket.make(input).items
    assert(actual == expected)
  }

  test("should make 1 orange") {
    val input = "Orange"
    val expected = List(ORANGE)
    val actual = Basket.make(input).items
    assert(actual == expected)
  }

  test("should make 1 apple 1 orange") {
    val input = "Apple,Orange"
    val expected = List(APPLE,ORANGE)
    val actual = Basket.make(input).items
    assert(actual == expected)
  }

  test("should make 2 apple 1 orange") {
    val input = "Apple,Orange,Apple"
    val expected = List(APPLE,ORANGE,APPLE)
    val actual = Basket.make(input).items
    assert(actual == expected)
  }

  test("should make 4 apple 2 orange") {
    val input = "Apple,Orange,Apple,Orange,Apple,Apple"
    val expected = List(APPLE,ORANGE,APPLE,ORANGE,APPLE,APPLE)
    val actual = Basket.make(input).items
    assert(actual == expected)
  }
}
