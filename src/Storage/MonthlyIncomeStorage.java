package Storage;

import java.sql.Statement;
import java.util.Scanner;
public class MonthlyIncomeStorage {
    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();
    public void addIncome(){
        System.out.println("Enter the date(mm-yyyy) : ");
        String date =input.next();
        System.out.println("Enter the Monthly Income: ");
        int monthIncome=input.nextInt();
        try{
            String query=String.format("insert into income(dateOfMonth,monthlyIncome) values(\"%s\",%d);",date,monthIncome);
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("successfully Added.");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
