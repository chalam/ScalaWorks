package learn

import java.sql.{Connection, DriverManager}

/**
 * Created by lamuel on 5/25/15.
 */
class JDBCSql {

  /**
   * A Scala JDBC connection example by Alvin Alexander,
   * <a href="http://alvinalexander.com" title="http://alvinalexander.com">http://alvinalexander.com</a>
   */
  object JDBCSql {

    def main(args: Array[String]) {
      // connect to the database named "mysql" on the localhost
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost/mysql"
      val username = "root"
      val password = "root"

      // there's probably a better way to do this
      var connection:Connection = null

      try {
        // make the connection
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)

        // create the statement, and run the select query
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT host, user FROM user")
        while ( resultSet.next() ) {
          val host = resultSet.getString("host")
          val user = resultSet.getString("user")
          println("host, user = " + host + ", " + user)
        }
      } catch {
        case e => e.printStackTrace
      }
      connection.close()
    }

  }
}
