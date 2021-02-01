package shopping

import java.math.BigDecimal

object Discounter {

  def discountBogof(name: String, items: List[Item]): BigDecimal = {
    val filtered = items.filter(item => item.name == name)
    val size = filtered.size
    val subset = filtered.take(size/2).map(item => item.price)
    Pricer.sum(subset)
  }

  def discount3for2(name: String, items: List[Item]): BigDecimal = {
    val filtered = items.filter(item => item.name == name)
    val size = filtered.size
    val subset = filtered.take((size/3)).map(item => item.price)
    Pricer.sum(subset)
  }

}
