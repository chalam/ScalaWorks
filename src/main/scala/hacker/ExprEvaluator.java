package hacker;
/*
import scala.util.parsing.combinator._
import scala.util.parsing.input._

class ExprEvaluator extends RegexParsers with PackratParsers {

  // Here is the rule       ...   and here is how to act on it

  lazy val expression: PackratParser[Int] =
    expression ~ "+" ~ term  ^^ { case e ~ "+" ~ t => e+t } |
    expression ~ "-" ~ term  ^^ { case e ~ "-" ~ t => e-t } |
    term                     ^^ { case t => t }
  lazy val term: PackratParser[Int] =
    term ~ "*" ~ atom        ^^ { case t ~ "*" ~ a => t*a } |
    term ~ "/" ~ atom        ^^ { case t ~ "/" ~ a => t/a } |
    atom                     ^^ { case a => a }
  lazy val atom: PackratParser[Int] =
    "-" ~ atom               ^^ { case "-" ~ a => -a } |
    "(" ~ expression ~ ")"   ^^ { case "(" ~ e ~ ")" => e } |
    integer                  ^^ { case i => i }
  lazy val integer: PackratParser[Int] =
    digitlist                ^^ { case dd => dd.toInt }
  lazy val digitlist: PackratParser[String] =
    digitlist ~ digit        ^^ { case dd ~ d => dd ++ d } |
    digit                    ^^ { case d => d }
  lazy val digit: PackratParser[String] =
    "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"

  def parseAll[T](p: Parser[T], input: String) =
    phrase(p)(new PackratReader(new CharSequenceReader(input)))
}
*/