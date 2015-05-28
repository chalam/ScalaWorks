package hacker

import scala.io.StdIn

/**
  * Created by lamuel on 5/19/15.
  */
object Warmup3 extends App {
  val t = StdIn.readInt()
  var ts = List[Int]()
  for (i <- 1 to t) {
    ts = StdIn.readInt() :: ts
  }
  ts = ts.reverse
//  println(ts.toString)

  //  val ts: List[Int] = List(0, 1, 2, 3, 4, 5, 6)

//  foreach
//  forall
  for (t <- ts) {
//    println(t)
    var n: Int = t
    var h = 1
    for (n <- 1 to t) {
        if (n % 2 == 0) h = h + 1
        if (n % 2 == 1) h = h * 2
      }
      println(h)
  }


}