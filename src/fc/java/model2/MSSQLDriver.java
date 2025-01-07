package fc.java.model2;

public class MSSQLDriver implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("Connecting to mssql" );
    }
}
