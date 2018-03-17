package example

import org.scalatest.{FlatSpec, Matchers}

/**
  * Tests for Sorter class.
  */
class SorterSpec extends FlatSpec with Matchers {

  "The Sorter object" should "say Apple, Peach, Orange" in {
    Sorter.items shouldEqual List("Apple", "Peach", "Orange")
  }

}
