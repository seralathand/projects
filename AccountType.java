package MyProject;
import java.text.DecimalFormat;
import java.util.*;
public class AccountType {
    Scanner input=new Scanner(System.in);
    DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance=0;
    private double savingBalance=0;

    public void setCustomerNumber(int customerNumber){
        this.customerNumber=customerNumber;
    }
    public int getCustomerNumber(){
        return customerNumber;
    }
    public void setPinNumber(int pinNumber){
        this.pinNumber=pinNumber;
    }
    public int getPinNumber(){
        return pinNumber;
    }
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingBalance(){
        return savingBalance;
    }
    public double calcCheckingWithdraw(double amount){
        checkingBalance=(checkingBalance-amount);
        return checkingBalance;
    }
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    public double calcCheckingDeposit(double amount){
        checkingBalance=(checkingBalance+amount);
        return checkingBalance;
    }
    public double calcSavingDeposit(double amount){
        savingBalance=(savingBalance+ amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("How much amount are you want to withdraw from Checking account");
        double amount=input.nextDouble();

        if((checkingBalance-amount)>=0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance: "+moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Insufficient Balance: "+"\n");
        }
    }

    public void getSavingWithdrawInput(){
        System.out.println("Saving Account balance: "+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw form saving Account: ");
        double amount =input.nextDouble();

        if((savingBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: "+savingBalance+"\n");
        }
        else{
            System.out.println("Insufficient Balance: "+"\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking Account Balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to deposit from Checking Account: ");
        double amount=input.nextDouble();

        if((checkingBalance+amount)>=0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account balance: "+moneyFormat.format(checkingBalance));
        }
        else{
            System.out.println("Balance cannot be negative."+"\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from saving Account");
        double amount=input.nextDouble();

        if((savingBalance+amount)>=0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: "+moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("Balance cannot be negative."+"\n");
        }
    }
}
