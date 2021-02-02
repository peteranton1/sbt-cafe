package cafe

import org.scalatest.FunSuite

class TrayTest extends FunSuite {

  test("should make 1 item") {
    val input = "Cola"
    val expected = Tray(List(Tray.menu.getOrElse("Cola", Tray.emptyItem)))
    val actual = Tray.make(input)
    assert(actual == expected)
  }

  test("should make 2 item") {
    val input = "Cola,Cheese Sandwich"
    val expected = Tray(List(
      Tray.menu.getOrElse("Cola", Tray.emptyItem),
      Tray.menu.getOrElse("Cheese Sandwich", Tray.emptyItem)
    ))
    val actual = Tray.make(input)
    assert(actual == expected)
  }

  test("should make 3 item") {
    val input = "Cola,Coffee,Cheese Sandwich"
    val expected = Tray(List(
      Tray.menu.getOrElse("Cola", Tray.emptyItem),
      Tray.menu.getOrElse("Coffee", Tray.emptyItem),
      Tray.menu.getOrElse("Cheese Sandwich", Tray.emptyItem)
    ))
    val actual = Tray.make(input)
    assert(actual == expected)
  }
}
