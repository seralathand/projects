package DailyExpanse;

import Storage.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DayOfTotalExpanse extends DailyDate {

    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();

    public void dayOfTotal(){
        try{
            String query=String.format("select costOfTheDay from personalEx where dateOfDay=\"%s\";",DailyDate.currentDate());
            Statement state=database.getConnect().createStatement();
            ResultSet result=state.executeQuery(query);

            if(result.next()){
                System.out.println("Today's Total Expanse: "+result.getInt(1));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
