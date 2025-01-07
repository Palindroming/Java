package fc.java.model2;


public class MysqlDriver implements Connection {

    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("Connecting to Mysql");
    }
}
