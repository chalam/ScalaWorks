package learn

/**
 * Created by lamuel on 5/24/15.
 */
object ForComp extends App {
  for (i <- 1 to 5) yield i % 2
  val a = Array(1, 2, 3, 4, 5)
  for (e <- a) yield e % 2
}
