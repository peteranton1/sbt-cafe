package cafe

import org.scalatest.FunSuite
import java.math.BigDecimal

class CafePricerTest extends FunSuite {

  test("should total 1 items") {
    val input = Tray.make("Cola")
    val expected = new BigDecimal("0.50")
    val actual = CafePricer.calcTotal(input.menuItems)
    assert(actual == expected)
  }

  test("should total 3 items") {
    val input = Tray.make("Cola,Coffee,Cheese Sandwich")
    val expected = new BigDecimal("3.50")
    val actual = CafePricer.calcTotal(input.menuItems)
    assert(actual == expected)
  }

  test("should tip 2 items only drinks") {
    val input = Tray.make("Cola,Coffee")
    val expected = new BigDecimal("0.00")
    val actual = CafePricer.calcTip(input.menuItems)
    assert(actual == expected)
  }

  test("should tip 3 items cold") {
    val input = Tray.make("Cola,Coffee,Cheese Sandwich")
    val expected = new BigDecimal("0.35")
    val actual = CafePricer.calcTip(input.menuItems)
    assert(actual == expected)
  }

  test("should tip 2 items hot") {
    val input = Tray.make("Coffee,Steak Sandwich")
    val expected = new BigDecimal("1.10")
    val actual = CafePricer.calcTip(input.menuItems)
    assert(actual == expected)
  }

  test("should tip max tip hot") {
    val input = Tray.make("Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich," +
      "Steak Sandwich," + "Steak Sandwich," + "Steak Sandwich,"
    )
    val expected = new BigDecimal("20.00")
    val actual = CafePricer.calcTip(input.menuItems)
    assert(actual == expected)
  }
}
