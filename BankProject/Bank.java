package BankProject;

public class Bank {
    public static void main(String[] args){
        start();
    }
    static BankStorage bank=new BankStorage();
    static public void start(){
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        System.out.println("3.Exit");
        System.out.println("Enter the choice..");
        int choice=Validation.numberValidate(1,3,"Input Mismatch, Re Enter ");
        switch(choice){
            case 1:
                bank.admin();
                start();
                break;
            case 2:
                bank.customerOption();
                start();
                break;
            default:
                break;
        }
    }
}
