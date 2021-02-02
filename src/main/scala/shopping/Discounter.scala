package shopping

import java.math.BigDecimal

object Discounter {

  def discountBogof(name: String, items: List[Item]): BigDecimal = {
    val denominator = 2
    discountInternal(name,items,denominator)
  }

  def discount3for2(name: String, items: List[Item]): BigDecimal = {
    val denominator = 3
    discountInternal(name,items,denominator)
  }

  private def discountInternal(name: String, items: List[Item],
                               denominator: Int): BigDecimal = {
    val filtered = items.filter(item => item.name == name)
    val size = filtered.size
    val subset = filtered.take(size/denominator).map(_.price)
    Pricer.sum(subset)
  }
}
