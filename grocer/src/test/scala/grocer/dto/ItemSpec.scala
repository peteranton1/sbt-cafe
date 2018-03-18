package grocer.dto

import org.scalatest._

class ItemSpec extends FlatSpec with Matchers {

  "Item.of" should "produce Apple at 60 pence" in {
    Item.of(Item.apple).name shouldEqual Item.apple
    Item.of(Item.apple).price shouldEqual 60
  }

  it should "produce Orange at 25 pence" in {
    Item.of(Item.orange).name shouldEqual Item.orange
    Item.of(Item.orange).price shouldEqual 25
  }

  it should "throw \"Unknown item: \" for unknown product" in {
    a[Error] should be thrownBy {
      Item.of("Pear")
    }
  }

  "Item.getItems" should "produce Apple,Apple,Orange" in {
    Item.getItems(
      List(Item.apple, Item.apple, Item.orange)
    ).length shouldEqual 3
  }

  it should "produce Orange" in {
    Item.getItems(
      List(Item.orange)
    ).length shouldEqual 1
  }

  it should "throw \"Unknown item: \" for unknown product" in {
    a[Error] should be thrownBy {
      Item.getItems(List("Pear"))
    }
  }


}

