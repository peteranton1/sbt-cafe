package example

/**
  * A simple Sorter
  */
object Sorter extends SortList with App {
  println(items)
}

trait SortList {
  lazy val items = List("Apple", "Peach", "Orange")
}