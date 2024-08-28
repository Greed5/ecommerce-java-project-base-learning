package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/webapp";
    private static final String user ="root";
    private static final String password ="1G0tM@F1rst$QLP@$$C0de0524$$";
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
