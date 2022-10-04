package DailyExpanse;
import Storage.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class ParticularDateExpanse {
    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();
    public void particularDate(){
        System.out.println("Enter the Date(dd-MM-yyyy): ");
        String date=input.next();

        try{
            String query=String.format("select food,travel,dresses,enjoyment,health,mobileRecharge,houseRent,costOfTheDay from " +
                    "personalEx where dateOfDay=\"%s\"",date);
            Statement state=database.getConnect().createStatement();
            ResultSet result=state.executeQuery(query);

            while(result.next()){
                int food=result.getInt("food");
                int travel=result.getInt("travel");
                int dresses=result.getInt("dresses");
                int enjoyment=result.getInt("enjoyment");
                int health=result.getInt("health");
                int mobileRecharge=result.getInt("mobileRecharge");
                int houseRent=result.getInt("houseRent");
                int costOfTheDay=result.getInt("costOfTheDay");

                System.out.println(date);
                System.out.println("----------");
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","Food","Travel","Dresses","Enjoyment","Health",
                        "Mobile ","House Rent","Total Cost");
                System.out.printf("%-15d%-15d%-15d%-15d%-15d%-15d%-15d%-15d\n",food,travel,dresses,enjoyment,health,mobileRecharge,houseRent,costOfTheDay);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
