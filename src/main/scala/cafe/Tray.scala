package cafe

import java.math.BigDecimal

sealed trait HotCold
object Hot extends HotCold
object Cold extends HotCold

sealed trait FoodDrink
object Food extends FoodDrink
object Drink extends FoodDrink

case class MenuItem(name: String, hotCold: HotCold, foodDrink: FoodDrink, price: BigDecimal)

case class Tray(menuItems: List[MenuItem])

object Tray {
  val emptyItem: MenuItem = MenuItem("Unknown", Cold, Drink, BigDecimal.ZERO)
  val menu: Map[String, MenuItem] = Map(
    "Cola" -> MenuItem("Cola", Cold, Drink, new BigDecimal("0.50")),
    "Coffee" -> MenuItem("Coffee", Hot, Drink, new BigDecimal("1.00")),
    "Cheese Sandwich" -> MenuItem("Cheese Sandwich", Cold, Food, new BigDecimal("2.00")),
    "Steak Sandwich" -> MenuItem("Steak Sandwich", Hot, Food, new BigDecimal("4.50"))
  )

  def make(input: String): Tray = {
    Tray(input.split(",").toList
      .map(name => menu.getOrElse(name, emptyItem)))
  }
}
