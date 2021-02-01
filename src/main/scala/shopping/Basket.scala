package shopping

import java.math.BigDecimal

case class Item(name: String, price: BigDecimal)

case class Basket(items: List[Item])

object Basket {
  val APPLE: Item = Item("Apple",new BigDecimal("0.60"))
  val ORANGE: Item = Item("Orange",new BigDecimal("0.25"))

  def make(input: String): Basket = {
    Basket(input.split(",").toList
      .map(s => {
        if (s == APPLE.name) APPLE
        else if (s == ORANGE.name) ORANGE
        else throw new Exception(s"Unknown product: $s")
      }))
  }
}
