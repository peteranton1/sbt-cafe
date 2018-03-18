package lists

import java.util.stream.Collectors

object ListPredicate1 {
  def main(args: Array[String]): Unit = {
    println("ListPredicate1 start.")

    val nums = List(2, -4, 6, 5, 8)
    val fruits = List("apple", "pineapple", "orange", "banana")

    println("List A nums: " + nums)
    println("List A fruits:   " + fruits)

    val nums2 = nums
      .filter(x => x > 0)
      .sorted

    println("List A nums: " + nums2)
    println("List A fruits:   " + fruits)
  }

}
