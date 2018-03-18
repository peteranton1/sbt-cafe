package grocer.dto

/**
  * Companion to Item representing a product.
  */
object Item {

  val apple = "Apple"
  val orange = "Orange"

  // a map of items
  private val items = Map(
    apple -> new Item(apple, 60),
    orange -> new Item(orange, 25)
  )

  /**
    * Get isteances of items based on the supplied strings.
    *
    * @param names of items to be included, duplicates allowed.
    * @return list of item objects representing input list.
    */
  def getItems(names: List[String]): List[Item] =
    names.map(name => of(name))

  /**
    * given a name, return the item instance
    *
    * @param name of item
    * @return item representing name.
    */
  def of(name: String): Item =
    if (items.contains(name)) items(name)
    else throw new Error("Unknown item: " + name)

}

/**
  * Item representing a single product.
  *
  * @param n name of item
  * @param p price of item
  */
class Item(n: String, p: Long) {
  val name: String = n
  val price: Long = p

  override def toString: String = name + " [" + price + "]"
}
