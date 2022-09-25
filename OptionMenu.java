package MyProject;
import java.text.DecimalFormat;
import java.io.IOException;
import java.util.*;
import java.sql.*;

public class OptionMenu extends AccountType  {
    Scanner menuInput=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    HashMap<Integer,Integer> data=new HashMap<Integer,Integer>();
    int selection;

    public void getLogin() throws SQLException {
        int x=1;
        do{
            try{

                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","dhanush");

                 Statement s=c.createStatement();

                 ResultSet rs=s.executeQuery("select customerNo,password from store");

                System.out.println("Enter the customer number: ");
                 setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter the Pin Number: ");
                setPinNumber(menuInput.nextInt());
                boolean status=true;
                while(rs.next()){
                    int customer=rs.getInt("customerNo");
                    int password =rs.getInt("password");
                    if(customer==getCustomerNumber() && password==getPinNumber()){
                        getAccountType();
                        x=2;
                        status=false;
                    }
                }
                if(status==true) {
                    System.out.println("Wrong customer or Pin Number" + "\n");
                }
            }
            catch(Exception e){
                System.out.println("You are entered wrong pin");
                x=2;
            }
        }while(x==1);
    }

    public void getAccountType(){
        System.out.println("Select the Account you want to access");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice");

        selection=menuInput.nextInt();
        switch(selection) {
            case 1:
            getChecking();
            break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM,bye.");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Money");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice: ");

        selection=menuInput.nextInt();
         switch(selection){
             case 1:
                 System.out.println("Checking Account Balance: "+moneyFormat.format(getCheckingBalance()));
                 getAccountType();
                 break;
             case 2:
                 getCheckingWithdrawInput();
                 getAccountType();
                 break;
             case 3:
                 getCheckingDepositInput();
                 getAccountType();
                 break;
             case 4:
                 System.out.println("Thank You for using this ATM, bye.");
                 break;
             default:
                 System.out.println("\n"+"Invalid choice."+"\n");
                 getChecking();
         }
}

public void getSaving(){
    System.out.println("Saving Account: ");
    System.out.println("Type 1 - View Balance");
    System.out.println("Type 2 - Withdraw Funds");
    System.out.println("Type 3 - Deposit Funds");
    System.out.println("Type 4 - Exit");
    System.out.println("Choice: ");
     selection=menuInput.nextInt();

     switch(selection){
         case 1:
             System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
             getAccountType();
             break;
         case 2:
             getSavingWithdrawInput();
             getAccountType();
             break;
         case 3:
             getSavingDepositInput();
             getAccountType();
             break;
         case 4:
             System.out.println("Thank You for using this ATM,bye.");
             break;
         default:
             System.out.println("\n"+"Invalid choice."+"\n");
             getSaving();
     }
    }
}
