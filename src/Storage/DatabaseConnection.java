package Storage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {

   Connection con;
    public Connection getConnect(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/personalExpanseProject",
                    "root", "dhanush");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
