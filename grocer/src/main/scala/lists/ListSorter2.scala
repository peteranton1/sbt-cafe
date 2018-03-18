package lists

object ListSorter2 {
  def main(args: Array[String]): Unit = {
    println("ListSorter2 start.")
    val list1 = List(2, -4, 6, 5, 8)
    val list2 = msort(list1)
    println("List unsorted: "+list1)
    println("List sorted:   "+list2)
  }

  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if(n==0) xs
    else {
      def merge(xs: List[Int], ys: List[Int])
        : List[Int] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
}
