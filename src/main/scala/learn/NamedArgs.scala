package learn

/**
 * Created by lamuel on 5/24/15.
 */
object NamedArgs {
  def main(args: Array[String]) {
    printName("Alvin", "Alex")
    printName(firstName="Alvin", lastName="Alexander")
    printName(firstName="Alvin")
    printName()
  }

  def printName(firstName:String = "Unknown", lastName:String = "Unknown") {
    System.out.format("Your name is %s %s\n", firstName, lastName)
  }
}