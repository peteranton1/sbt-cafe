package cafe

import java.math.BigDecimal

object CafePricer {

  val maxTip = new BigDecimal("20.00")
  val hotFoodRate = new BigDecimal("0.20")
  val coldFoodRate = new BigDecimal("0.10")

  def calcTotal(menuItems: List[MenuItem]): BigDecimal = {
    menuItems.map(_.price).foldLeft(BigDecimal.ZERO) {
      (acc,price) => acc.add(price)
    }
  }

  def calcTip(menuItems: List[MenuItem]): BigDecimal = {

    val total = calcTotal(menuItems)
    val hasFood = menuItems.count(_.foodDrink == Food) > 0
    val hasHotFood = menuItems.count(item =>
      item.hotCold == Hot && item.foodDrink == Food) > 0

    if(!hasFood) BigDecimal.ZERO.setScale(2)
    else if(hasHotFood) {
      total
        .multiply(hotFoodRate)
        .min(maxTip).setScale(2)
    } else {
      total
        .multiply(coldFoodRate)
        .min(maxTip).setScale(2)
    }
  }
}
