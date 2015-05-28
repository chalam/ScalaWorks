package learn

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

/**
 * Created by lamuel on 5/25/15.
 */
object FileRead {
  val filename = "fileopen.scala"
  for (line <- Source.fromFile(filename).getLines()) {
    println(line)
  }

  val fileLines = io.Source.fromFile("Colors.scala").getLines.toList
  fileLines.foreach(println)

  try {
    for (line <- Source.fromFile(filename).getLines()) {
      println(line)
    }
  } catch {
    case ex: FileNotFoundException => println("Couldn't find that file.")
    case ex: IOException => println("Had an IOException trying to read that file")
  }
}
