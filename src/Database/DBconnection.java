package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/DBname";
    private static final String user ="root";
    private static final String password ="password";
    public static Connection getConnection(){
        Connection connected = null;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connected= DriverManager.getConnection(url,user,password);
            }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return connected;
    }
}
