package View;
import DailyExpanse.DayOfTotalExpanse;
import DailyExpanse.Expanses;
import DailyExpanse.ParticularDateExpanse;
import Storage.DailyExpanseStorage;
import Storage.MonthlyIncomeStorage;
import java.util.Scanner;

public class Enter {
    Scanner input=new Scanner(System.in);
    Expanses expanses=new Expanses();
    IncomeInfo incomeInfo=new IncomeInfo();

     public void start(){
         DailyExpanseStorage dailyExpanse=new DailyExpanseStorage();
         MonthlyIncomeStorage monthlyIncome=new MonthlyIncomeStorage();
         DayOfTotalExpanse todayExpanse=new DayOfTotalExpanse();
         ParticularDateExpanse particularExpanse=new ParticularDateExpanse();


        System.out.println("\nPersonal Expanse");System.out.println("----------------");
        System.out.println("1.Add Daily Expanse");
        System.out.println("2.Today's Total Expanse");
        System.out.println("3.Search Day's Expanse ");
        System.out.println("4.Add Monthly Income");
        System.out.println("5.Income Information");
        System.out.println("6.Log Out");
        int choice=input.nextInt();
        switch(choice){
            case 1:
                expanses.addDate();
                start();
            case 2:
                todayExpanse.dayOfTotal();
                start();
            case 3:
                particularExpanse.particularDate();
                start();
            case 4:
                monthlyIncome.addIncome();
                start();
            case 5:
                incomeInfo.monthlyInfo();
                start();
            default:
                break;

        }
}
    public static void main(String[] args){
        Enter enter=new Enter();
        enter.start();
    }
}