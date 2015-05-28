package learn

/**
 * Created by lamuel on 5/24/15.
 */
object Extender extends App {
  implicit def stringToString(s: String) = new BetterString(s)
  println("HAL".increment)
}
class BetterString(val s: String) {
  def increment = s.map(c => (c + 1).toChar)
}
