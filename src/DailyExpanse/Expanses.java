package DailyExpanse;

import Storage.DatabaseConnection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Expanses extends DailyDate{
  Scanner input =new Scanner(System.in);
  DatabaseConnection database=new DatabaseConnection();
  RegularExpanse regular=new RegularExpanse();
  MonthlyOneExpanse month=new MonthlyOneExpanse();
  DayOfTotalExpanse totalExpanse=new DayOfTotalExpanse();

    public void addDate(){
        try{
            String query=String.format("insert into personalEx(dateOfDay) values(\"%s\");",DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Today: "+DailyDate.currentDate()+"\n");
            expanses();
        }
        catch(SQLException e){
            System.out.println("Today: "+DailyDate.currentDate()+"\n");
            expanses();
        }
    }


    private void expanses(){
        System.out.println("1.Food Expanse");
        System.out.println("2.Travel Expanse");
        System.out.println("3.Dresses & Accessories");
        System.out.println("4.Enjoyment Expanse");
        System.out.println("5.Health Expanse");
        System.out.println("6.Mobile Recharge");
        System.out.println("7.House Rent");
        System.out.println("Enter the Choice: ");
        int choice=input.nextInt();
        switch(choice){
            case 1:
                regular.food();
                expanses();
                break;
            case 2:
                regular.travel();
                expanses();
                break;
            case 3:
                regular.dresses_Accessories();
                expanses();
                break;
            case 4:
                regular.enjoyment();
                expanses();
                break;
            case 5:
                month.health();
                expanses();
                break;
            case 6:
                month.mobileRecharge();
                expanses();
                break;
            case 7:
                month.houseRent();
                expanses();
                break;
            default:
                break;
        }
    }
}
