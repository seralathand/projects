package DailyExpanse;
import Storage.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class RegularExpanse extends DailyDate{
    Scanner input=new Scanner(System.in);
    DatabaseConnection database=new DatabaseConnection();


    public void food(){
        System.out.println("Enter the Today's Food Expanse: ");
        int food=input.nextInt();
        try{
            String query=String.format("update personalEx set food=%d where dateOfDay=\"%s\"",
                    food,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your Food Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void travel(){
        System.out.println("Enter the Today's Travel Expanse: ");
        int travel=input.nextInt();
        try{
            String query=String.format("update personalEx set travel=%d where dateOfDay=\"%s\"",
                    travel,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your travel Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void dresses_Accessories(){
        System.out.println("Enter the Today's Dresses & Accessories Expanse: ");
        int dresses_Accessories=input.nextInt();
        try{
            String query=String.format("update personalEx set dresses=%d where dateOfDay=\"%s\"",
                    dresses_Accessories,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your Dresses & Accessories Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void enjoyment(){
        System.out.println("Enter the Today's Enjoyment Expanse: ");
        int enjoyment=input.nextInt();
        try{
            String query=String.format("update personalEx set enjoyment=%d where dateOfDay=\"%s\"",
                    enjoyment,DailyDate.currentDate());
            Statement state=database.getConnect().prepareStatement(query);
            state.executeUpdate(query);
            System.out.println("Your enjoyment Expanse Added Successfully\n");

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
