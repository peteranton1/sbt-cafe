package shopping

/*
Step 1: Shopping cart
---------------------

You are building a checkout system for a shop which
only sells apples and oranges.

* Apples cost 60p
* Oranges cost 25p

Build a checkout system which takes a list of items
scanned at the till and outputs the total cost

For example:

[ Apple, Apple, Orange, Apple ] => £2.05

Make reasonable assumptions about the inputs to your
solution; for example, many candidates take a list of
strings as input

 */
object Shopping {
  import java.math.BigDecimal

  def main(args: Array[String]): Unit = {
    val basket = Basket.make("Apple,Apple,Orange,Apple")
    println("basket:")
    basket.items.foreach(println(_))
    println("prices:")
    val allPrices = basket.items.map(_.price)
    allPrices.foreach(item => println(item))
    val allPrice = Pricer.sum(allPrices)
    println(s"allPriceSum: $allPrice")
  }
}
