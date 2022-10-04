package View;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

import DailyExpanse.DailyDate;
import Storage.DatabaseConnection;
public class IncomeInfo {
    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();
    NumberFormat nf=NumberFormat.getCurrencyInstance(new Locale("en","in"));

       public void monthlyInfo(){
           System.out.println("Enter the Month & Year Only(mm-yyyy): ");
           String date=input.next();

           String query=String.format("select dateOfMonth,monthlyIncome,totalExpanse,remainingAmount from income where dateOfMonth=\"%s\"",date);
           try {
               Statement state = database.getConnect().createStatement();
               ResultSet result=state.executeQuery(query);

               while(result.next()){
                   String dateOfMonth=result.getString("dateOfMonth");
                   int monthlyIncome=result.getInt("monthlyIncome");
                   int totalExpanse=result.getInt("totalExpanse");
                   int remaingAmount=result.getInt("remainingAmount");
                   System.out.println("Income Details: ");
                   System.out.println("---------------");
                   System.out.printf("%-15s%-15s%-15s%-15s\n","Date","Month Income","Total Expanse","Remaining Amount");
                   System.out.printf("%-15s%-15d%-15d%-15d\n", DailyDate.currentDate(),monthlyIncome,totalExpanse,remaingAmount);
               }
           }
           catch(SQLException e){
               System.out.println(e.getMessage());
           }

       }
}
