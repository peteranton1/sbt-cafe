package grocer.util

import grocer.dto.Item
import org.scalatest.{FlatSpec, Matchers}

class PricerSpec extends FlatSpec with Matchers {

  "Pricer.getTotal" should "produce Apple*3 Orange*1 at 205 pence" in {
    val items = Item.getItems(
      List(
        Item.apple,Item.apple,
        Item.orange,Item.apple))
    Pricer.getTotal(items) shouldEqual 205
  }

  it should "produce Orange * 4 at 100 pence" in {
    val items = Item.getItems(
      List(
        Item.orange,Item.orange,
        Item.orange,Item.orange))
    Pricer.getTotal(items) shouldEqual 100
  }

  it should "produce Apple*3 & Orange*4 at 280 pence" in {
    val items = Item.getItems(
      List(
        Item.orange,Item.orange,
        Item.apple,Item.apple,
        Item.apple,
        Item.orange,Item.orange))
    Pricer.getTotal(items) shouldEqual 280
  }

  it should "produce Apple*0 at 0 pence" in {
    val items = Item.getItems(List())
    Pricer.getTotal(items) shouldEqual 0
  }

  "Pricer.getDiscounted" should "produce Apple*3 Orange*1 at 145 pence" in {
    val items = Item.getItems(
      List(
        Item.apple,Item.apple,
        Item.orange,Item.apple))
    Pricer.getDiscounted(items) shouldEqual 145
  }

  it should "produce Orange * 4 at 75 pence" in {
    val items = Item.getItems(
      List(
        Item.orange,Item.orange,
        Item.orange,Item.orange))
    Pricer.getDiscounted(items) shouldEqual 75
  }

  it should "produce Apple*3 & Orange*4 at 195 pence" in {
    val items = Item.getItems(
      List(
        Item.orange,Item.orange,
        Item.apple,Item.apple,
        Item.apple,
        Item.orange,Item.orange))
    Pricer.getDiscounted(items) shouldEqual 195
  }

  it should "produce Apple*0 at 0 pence" in {
    val items = Item.getItems(List())
    Pricer.getDiscounted(items) shouldEqual 0
  }
}

