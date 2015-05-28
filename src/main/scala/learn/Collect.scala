package learn

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions._

/**
 * Created by lamuel on 5/24/15.
 */
object Collect extends App {


  var fruits = ArrayBuffer[String]()
  fruits += "Apple"
  fruits += "Banana"
  fruits += "Orange"

  println(fruits(0))
  println(fruits.length)

  val fruit = Array("Apple", "Banana", "Orange")
  println(fruit(1))

  //convert a Scala array (sequence) to string with mkString
  val words = Array("Hello", "world", "it's", "me")
  val str = words.mkString(", ")
  println(str)

//  var list = new java.util.ArrayList[Int]()
  var list = new ArrayBuffer()
  list.add(1)
  list.add(2)
//  list.forEach(i => println(i))

  // List
  val x = List(1,2,3)
  x.foreach { println }

  var sum = 0
  x.foreach(sum += _)
  println(sum)

  val names = Vector("Bob", "Fred", "Joe", "Julia", "Kim")
  for (name <- names if name.startsWith("J")) println(name)

  val a1 = List(1,2,3)
  val b = List(4,5,6)

  val c = a1 ::: b //merge
  val c1 = List.concat(a1, b)
  val c2 = a1 ++ b //concat

  val num = List.range(1, 10)
  val even = List.range(0, 10, 2)

  val foos = List.fill(3)("foo")

  val xx = List.tabulate(5)(n => n * n)

  // prepend an element to the list
  val yy = 0 :: x

  val xy = List(1,2,3,4,5,6,7,8,9,10)
  val evens = xy.filter(a => a % 2 == 0)

  // less that 6
  val y1 = x.takeWhile(a => a < 6)
  val y2 = x.dropWhile(a => a < 6)

  val even1 = x.partition(a => a % 2 == 0)
  val even2 = x.find(a => a % 2 == 0)

//  val sorted = xy.sort(_ < _)

  // Map
  val m1 = Map("fname" -> "Al", "lname" -> "Alexander")
  for ((k,v) <- m1) printf("key: %s, value: %s\n", k, v)

  // version 1 (tuples)
  m1 foreach (x => println (x._1 + "-->" + x._2))

  // version 2 (foreach and case)
  m1 foreach {case (key, value) => println (key + "-->" + value)}

  // Map keys
  m1.keys.foreach( x => println(m1(x)))

  // create an empty map
  var states1 = scala.collection.mutable.Map[String, String]()

  // create a map with initial elements
  var states = scala.collection.mutable.Map("AL" -> "Alabama", "AK" -> "Alaska")

  // add elements with +=
  states += ("AZ" -> "Arizona")
  states += ("CO" -> "Colorado", "KY" -> "Kentucky")

  // remove elements with -=
  states -= "KY"
  states -= ("AZ", "CO")

  // update elements by reassigning them
  states("AK") = "Alaska, The Big State"

  //tuples
  val things = ("a", 1, 3.5)
  val(name, age, weight) = ("a", 1, 3.5)
//  String.format("name: %s, age %d, weight %3.1f", name, age, weight)
//  "%s, age %d weight %d".format(name, age, weight)

  val oauth_token="FOO&oauth_token_secret=BAR&oauth_expires_in=3600"
  val nameValuePairs = oauth_token.split("&")
  val nameValuePairs1 = oauth_token split "&"

  val foo = """Line 1.
Line 2.
Line 3.""".stripMargin('|').replaceAll("\n", " ")
  println(foo)

  val a = "foo\n".stripLineEnd
}
