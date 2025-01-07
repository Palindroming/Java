package fc.java.model2;
//OracleDriver는 Oracle회사에서 만들어서 제공하면 된다. (Driver)
import java.sql.SQLException;

public class OracleDriver implements Connection{


    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("Connecting to Oracle");

    }
}
