package BankProject;
import java.text.NumberFormat;
import java.util.*;

public class BankStorage {

    private Scanner input=new Scanner(System.in);
    public void admin(){
        System.out.println("Enter the Username: ");
        String userName=Validation.stringValidate(input.nextLine());
        System.out.println("Enter the password: ");
        String password=Validation.passwordValidate(input.next());
        if(adminCheck(userName,password)==true)
            new AllCutomer().showAccount();
        else{
            System.out.println("Your UserName & Password Incorrect!!!");
        }
    }
    public boolean adminCheck(String userName,String password){
        return userName.equals("seralathand")&&password.equals("Sera@111");
    }

        ExistingCustomer obj=new ExistingCustomer();
    public  void customerOption(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nWelcome to Indian Bank");
        System.out.println("----------------------");
        System.out.println("1.New Customer");
        System.out.println("2.Already Have an Account");
        System.out.println("3.Exit");
        System.out.println("Enter your choice...");
        byte choice =(byte) Validation.numberValidate(1,3,"Input Mismatch, Re Enter: ");

        switch(choice){
            case 1:
               obj.creatAccount();
                customerOption();
                break;
            case 2:
                obj.login();
                customerOption();
                break;
            default:
                System.out.println("Thank You!!!");
        }
    }
}
