package lists

object ListSorter1 {
  def main(args: Array[String]): Unit = {
    println("ListSorter1 start.")
    val list1 = List(7,2,3,9)
    val list2 = isort(list1)
    println("List unsorted: "+list1)
    println("List sorted:   "+list2)
  }

  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => x :: List()
      case y :: ys =>
        if (x < y)
          x :: y :: ys
        else y :: insert(x, ys)
    }

}
