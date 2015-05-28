package hacker

import scala.io.StdIn

/**
 * Created by lamuel on 5/19/15.
 */
object Warmup2 extends App {
  val n = StdIn.readInt()
  //recommended
  (1 to n).map(i => StdIn.readLine().split(" ").map(_.toInt).sum).foreach(println)

  /*
    another way
    for (i <- 1 to n) {
    val Array(a, b) = readLine.split(" ").map(_.toInt)
    println(a + b)
  }
  */
}