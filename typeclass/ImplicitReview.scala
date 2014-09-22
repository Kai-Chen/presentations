package com.sorrentocorp.presentation.typeclass

object ImplicitReview {

  object RightArrowExample {
    val map1 = Map("a" -> 1)
    val map2: Map[String, Int] = Map.apply(???) // needs a Tuple2[String, Int]
    // because we have in scala.Predefs
    // @inline implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] = new ArrowAssoc(x)
    // "a" is converted to any2ArrowAssoc[String]("a")
    val map3: Map[String, Int] = Map.apply(any2ArrowAssoc[String]("a").->(1))
    // which is converted to new ArrowAssoc[String]("a")
    val map4: Map[String, Int] = Map.apply((new ArrowAssoc[String]("a")).->(1))
  }

  object StreamExample {
    val fib: Stream[Int] = {
      def loop(h: Int, n: Int): Stream[Int] = h #:: loop(n, h + n)
      loop(1, 1)
    }
  }

  object OrderingExample {
    val list1 = List(1,3,5,2,4,6)
    list1.sorted

    val map = Map("a" -> 1L, "b" -> 2L, "Bill" -> 81000000000l)
    map.toList.sorted
  }
}
