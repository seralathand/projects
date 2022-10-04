package DailyExpanse;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import Storage.DatabaseConnection;
public class MonthlyOneExpanse extends DailyDate{
    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();

    public void health(){
        System.out.println("Enter the health Expanse: ");
        int health=input.nextInt();
        try{
            String query=String.format("update personalEx set health=%d where dateOfDay=\"%s\"",
                    health,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your health Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void mobileRecharge(){
        System.out.println("Enter the Mobile Recharge Expanse: ");
        int mobileRecharge=input.nextInt();
        try{
            String query=String.format("update personalEx set mobileRecharge=%d where dateOfDay=\"%s\"",
                    mobileRecharge,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your Mobile Recharge Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void houseRent(){
        System.out.println("Enter the Month House Rent Expanse: ");
        int houseRent=input.nextInt();
        try{
            String query=String.format("update personalEx set houseRent=%d where dateOfDay=\"%s\"",
                    houseRent,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your House Rent Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
