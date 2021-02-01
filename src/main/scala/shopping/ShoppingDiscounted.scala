package shopping

import java.math.BigDecimal

object ShoppingDiscounted {

  def main(args: Array[String]): Unit = {
    val basket = Basket.make("Apple,Apple,Orange,Apple,Orange,Orange,Apple")
    println("basket:")
    basket.items.foreach(item => println(item))
    println("prices:")
    val allPrices = basket.items.map(_.price)
    allPrices.foreach(println(_))
    val allPrice = Pricer.sum(allPrices)
    println(s"allPriceSum: $allPrice")

    val discount1 = Discounter.discountBogof(Basket.APPLE.name, basket.items)
    println(s"discountBogof: $discount1")
    val discount2 = Discounter.discount3for2(Basket.ORANGE.name, basket.items)
    println(s"discount3for2: $discount2")

    val discounted = allPrice.subtract(discount1).subtract(discount2)
    println(s"discounted: $discounted")
  }
}
