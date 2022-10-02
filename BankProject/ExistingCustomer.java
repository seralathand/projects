package BankProject;
import java.util.*;

 class ExistingCustomer extends NewCustomer {
     ExistingCustomer(){
         customers.add(new CustomerDetails("Raja@11","Raja","6373024820","raja13@gmail.com",20,500));
         customers.add(new CustomerDetails("Sara@12","Saravanan","6301891343","saravanaa45@gmail.com",23,500));
         customers.add(new CustomerDetails("Hari@13","Hari","6302984643","harihari13@gmail.com",34,500));
         transaction.put(11111,new LinkedList<>());
         transaction.put(11112,new LinkedList<>());
         transaction.put(11113,new LinkedList<>());
         user=customers.size();
     }
   public void login(){
        System.out.println("LogIn");
        System.out.println("-----");
        System.out.println("Enter your Account Number: ");
        int accNo= Validation.numberValidate(11110,100000,"Invalid Account Number, Re Enter: ");

        System.out.println("Enter your password: ");
        String password= Validation.passwordValidate(input.next());

        boolean flag=true;
        for(int index=0;index<customers.size();index++){
            if(customers.get(index).getAccNo()==accNo && customers.get(index).getPassword().equals(password)){
                flag=false;
                choices(index);
                break;
            }
        }
        if(flag==true) {
            System.out.println("You are entered Wrong Account Number & Password\n1.Try Again\n2.Exit");
           if(input.nextInt()==1)
               login();
           else
               return;
        }
        else
            System.out.println("Thank You For Visiting our Bank");

    }
    private void choices(int index){
        UserProcess process=new UserProcess();
        System.out.println("\nStatement");
        System.out.println("---------");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Deposit Money");
        System.out.println("4.Money Transfer");
        System.out.println("5.Transaction Details");
        System.out.println("6.Log Out");

        System.out.println("Enter the choice...");
        byte statementSelect=(byte) Validation.numberValidate(1,6,"Input Mismatch, Re Enter: ");
        switch(statementSelect){

            case 1:
                process.checkMoney(index);
                choices(index);
                break;
            case 2:
               process.withdrawMoney(index);
                choices(index);
                break;
            case 3:
               process.depositMoney(index);
                choices(index);
                break;
            case 4:
                process.moneyTransfer(index);
                choices(index);
                break;
            case 5:
                process.showTransaction(index);
                choices(index);
                break;
            default:
                break;
        }
    }

}
