package fc.java.course2.part1;

import fc.java.model2.Connection;
import fc.java.model2.MSSQLDriver;
import fc.java.model2.MysqlDriver;
import fc.java.model2.OracleDriver;

public class DataBaseConnection {

    public static void main(String[] args) {
        //Oracle DB 접속
        Connection conn = new OracleDriver();
        conn.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");

        //mysql 접속
        Connection conn2 = new MysqlDriver();
        conn2.getConnection("jdbc:mysql://localhost:3306/test", "hr", "hr");

        //mssql 접속
        Connection conn3 = new MSSQLDriver();
        conn3.getConnection("jdbc:mysql://localhost:3306/test", "hr", "hr");
    }
}
