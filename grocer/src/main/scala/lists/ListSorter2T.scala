package lists
import math.Ordering

object ListSorter2T {
  def main(args: Array[String]): Unit = {
    println("ListSorter2T start.")

    val list1 = List(2, -4, 6, 5, 8)
    val list2 = msort(list1)(Ordering.Int)
    println("List unsorted: "+list1)
    println("List sorted:   "+list2)

    val list1s = List("apple","pineapple","orange","banana")
    val list2s = msort(list1s)(Ordering.String)
    println("List unsorted: "+list1s)
    println("List sorted:   "+list2s)
  }

  def msort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if(n==0) xs
    else {
      def merge(xs: List[T], ys: List[T])
        : List[T] = (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord.lt(x,y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }
}
