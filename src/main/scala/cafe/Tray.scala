package cafe

import java.math.BigDecimal

case class MenuItem(name: String, hotCold: String, foodType: String, price: BigDecimal)

case class Tray(menuItems: List[MenuItem])

object Tray {
  val emptyItem: MenuItem = MenuItem("Unknown", "Cold", "Drink", BigDecimal.ZERO)
  val menu: Map[String, MenuItem] = Map(
    "Cola" -> MenuItem("Cola", "Cold", "Drink", new BigDecimal("0.50")),
    "Coffee" -> MenuItem("Coffee", "Hot", "Drink", new BigDecimal("1.00")),
    "Cheese Sandwich" -> MenuItem("Cheese Sandwich", "Cold", "Food", new BigDecimal("2.00")),
    "Steak Sandwich" -> MenuItem("Steak Sandwich", "Hot", "Food", new BigDecimal("4.50"))
  )

  def make(input: String): Tray = {
    Tray(input.split(",").toList
      .map(name => menu.getOrElse(name, emptyItem)))
  }
}
