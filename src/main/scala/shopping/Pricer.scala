package shopping

import java.math.BigDecimal

object Pricer {

  def filter(name: String, items: List[Item]): List[BigDecimal] =
    items
      .filter(item => item.name == name)
      .map(item => item.price)

  def sum(prices: List[BigDecimal]): BigDecimal = {
    prices.foldLeft(BigDecimal.ZERO) {
      (acc, price) => acc.add(price)
    }
  }

}
