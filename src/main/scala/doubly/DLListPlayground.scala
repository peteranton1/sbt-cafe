package doubly

object DLListPlayground {

  // O(1) - accessing
  // O(n) - everything else

  trait MyList[+T] {
    def head: T

    def tail: MyList[T]

    def prepend[S >: T](element: S): MyList[S]
  }

  case object Empty extends MyList[Nothing] {
    override def head: Nothing = throw new NoSuchElementException("head of empty list")

    override def tail: MyList[Nothing] = throw new NoSuchElementException("tail of empty list")

    override def prepend[S >: Nothing](element: S): MyList[S] = throw new NoSuchElementException("prepend of empty list")
  }

  case class Cons[+T](override val head: T, override val tail: MyList[T]) extends MyList[T] {
    override def prepend[S >: T](element: S): MyList[S] = Cons(element, this)
  }

  trait DLList[+T] { // 1 - 2 - 3 - 4 - 5
    def value: T

    def prev: DLList[T]

    def next: DLList[T]

    def prepend[S >: T](element: S): DLList[S]

    def append[S >: T](element: S): DLList[S]

    def updatePrev[S >: T](newPrev: => DLList[S]): DLList[S]

    def updateNext[S >: T](newNext: => DLList[S]): DLList[S]
  }

  object DLEmpty extends DLList[Nothing] {
    override def value = throw new NoSuchElementException("value of empty list")

    override def prev = throw new NoSuchElementException("prev of empty list")

    override def next = throw new NoSuchElementException("next of empty list")

    override def prepend[S >: Nothing](element: S) = new DLCons(element, DLEmpty, DLEmpty)

    override def append[S >: Nothing](element: S) = new DLCons(element, DLEmpty, DLEmpty)

    override def updateNext[S >: Nothing](newNext: => DLList[S]): DLList[S] = this

    override def updatePrev[S >: Nothing](newPrev: => DLList[S]): DLList[S] = this
  }

  class DLCons[+T](override val value: T,
                   p: => DLList[T],
                   n: => DLList[T]) extends DLList[T] {
    // call by need
    override lazy val prev: DLList[T] = p
    override lazy val next: DLList[T] = n

    override def updatePrev[S >: T](newPrev: => DLList[S]): DLList[S] = {
      lazy val result: DLList[S] = new DLCons(value, newPrev, n.updatePrev(result))
      result
    }

    override def updateNext[S >: T](newNext: => DLList[S]): DLList[S] = {
      lazy val result: DLList[S] = new DLCons(value, newNext, p.updateNext(result))
      result
    }

    override def append[S >: T](element: S): DLList[S] = {
      lazy val result: DLList[S] = new DLCons[S](value,
        p.updateNext(result), n.append(element).updatePrev(result))
      result
    }

    override def prepend[S >: T](element: S): DLList[S] = {
      lazy val result: DLList[S] = new DLCons(value,
        p.prepend(element).updateNext(result), n.updatePrev(result))
      result
    }
  }

  def main(args: Array[String]): Unit = {
    val list = DLEmpty
      .prepend(1)
      .append(2)
      .prepend(3)
      .append(4)
    println(list.value)
    println(list.next.value)
    println(list.prev.value)
    println(list.prev.next.value)
    println(list.next.next.value)
    println(list.next.next.prev.prev.value)
  }
}
