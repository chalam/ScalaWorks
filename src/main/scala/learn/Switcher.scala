package learn

import scala.annotation.switch

/**
 * Created by lamuel on 5/24/15.
 */
object Switcher extends App {
  val i = 2
  val x = (i: @switch) match {
    case 1  => "One"
    case 2  => "Two"
    case _  => "Other"
  }
  val month = i match {
    case 1  => "January"
    case 2  => "February"
    case 3  => "March"
    case 4  => "April"
    case 5  => "May"
    case 6  => "June"
    case 7  => "July"
    case 8  => "August"
    case 9  => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _  => "Invalid month"  // the default, catch-all
  }
  println(i)
  println(month)
}
