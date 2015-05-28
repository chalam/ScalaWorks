package hacker

/**
 * Created by lamuel on 5/23/15.
 */
object Zoro extends App {

  def toBaseB(n: Int, b: Int): Seq[Int] = {
    require(n > 0 && b >= 2, "number should be positive and base should be greater than zero")
    val r = n % b
    var q = n / b
    if (q > 0) {
      (toBaseB(q, b) :+ r)
    }
    else
      Array(r)
  }

  def fromBaseB(a: Seq[Int], b: Int): Int = {
    require(b >= 2 && a.forall(_ >= 0) && a.forall(_ <= b-1))
    (a :\ (0,1)){ case (aj,(r,bj)) => (r+aj*bj,bj*b) }._1
  }

  println(toBaseB(754, 10))
  println(toBaseB(754, 2))
  println(toBaseB(754, 8))
  println(toBaseB(754, 16))
//  println(toBaseB(-754, 1))

  println(fromBaseB(Array(1, 0, 1, 1, 1, 1, 0, 0, 1, 0), 2))
  println(fromBaseB(Array(1, 3, 6, 2), 8))
  println(fromBaseB(Array(2, 15, 1), 16))
}
