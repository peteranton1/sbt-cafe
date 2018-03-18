package grocer.util

import grocer.dto.Item

object Pricer {

  /**
    * Calculate the total price of items
    *
    * @param items to total
    * @return total price
    */
  def getTotal(items: List[Item]): Long = {

    // calculate total price without discounts
    val stdPrice = items.map(i => i.price).sum

    // return total
    stdPrice
  }

  /**
    * Calculate total price including discounts
    *
    * @param items to total
    * @return discounted total
    */
  def getDiscounted(items: List[Item]): Long = {

    val stdPrice = getTotal(items)

    // calculate discounts
    val groupMap: Map[String, List[Item]] = items.groupBy(_.name)
    val apples = groupMap.get(Item.apple)
    val oranges = groupMap.get(Item.orange)

    val numberOfApples = if (apples.isEmpty) 0 else apples.get.length
    val numberOfOranges = if (oranges.isEmpty) 0 else oranges.get.length

    val discount =
      (numberOfApples / 2 * Item.of(Item.apple).price) +
        (numberOfOranges / 3 * Item.of(Item.orange).price)

    // return value
    stdPrice - discount
  }

}
