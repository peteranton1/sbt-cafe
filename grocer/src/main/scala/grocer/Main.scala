package grocer

import grocer.dto.Item
import grocer.util.Pricer

object Main {
  def main(args: Array[String]): Unit = {
    println("Grocer app")

    val items = Item.getItems(List(
      Item.apple, Item.orange, Item.apple,
      Item.apple, Item.orange, Item.orange,
      Item.orange))

    val prices = items.map(i => i.price)

    println("Items Bought: " + items)
    println("Prices Bought: " + prices)
    println("Total Price with no discounts: " + Pricer.getTotal(items))
    println("Total Price with discounts   : " + Pricer.getDiscounted(items))
  }
}
