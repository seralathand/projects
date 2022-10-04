package Storage;

import DailyExpanse.DailyDate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DailyExpanseStorage extends DailyDate {
    DatabaseConnection database=new DatabaseConnection();

    public DailyExpanseStorage(){
        dailyProcess();
        incomeUpdate();
    }
    public void dailyProcess(){
        try{
            Statement state=database.getConnect().createStatement();
            String query=String.format("select sum(food+travel+dresses+enjoyment+health+mobileRecharge+" +
                    " houseRent) from personalEx where dateOfDay=\"%s\";", DailyDate.currentDate());
            ResultSet result=state.executeQuery(query);

            int store=0;
            if(result.next()){
                store=result.getInt(1);
            }
            String query1=String.format("update personalEx set costOfTheDay=%d where dateOfDay=\"%s\"",store,DailyDate.currentDate());
            Statement state1=database.getConnect().prepareStatement(query);
            state1.executeUpdate(query1);

            String query2=String.format("update income set totalExpanse=%d where dateOfMonth=\"%s\";",store,DailyDate.currentMonth());
            Statement state2=database.getConnect().prepareStatement(query2);
            state2.executeUpdate(query2);

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void incomeUpdate(){
        String query=String.format("select sum(monthlyIncome-totalExpanse) from income where dateOfMonth=\"%s\";",DailyDate.currentMonth());
        try{
            int store=0;
            Statement state=database.getConnect().createStatement();
            ResultSet result=state.executeQuery(query);
            if(result.next()){
                store=result.getInt(1);
            }
            String query1=String.format("update income set remainingAmount=%d where dateOfMonth=\"%s\"",store,DailyDate.currentMonth());
            Statement state1=database.getConnect().prepareStatement(query1);
            state1.executeUpdate(query1);
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    }

