import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    final String url = "jdbc:mysql://localhost:3306/smk4?useLegacyDatetimeCode=false&serverTimezone=UTC"; //Database -> db_java
    final String user = "root";
    final String pass = "";
    final String driver = "com.mysql.cj.jdbc.Driver";
}
