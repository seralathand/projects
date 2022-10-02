package BankProject;

 class UserProcess extends NewCustomer{
    public void checkMoney(int index){
        System.out.println("Your Current Account Balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
    }

    public void withdrawMoney(int index){
        System.out.println("Your Current Account Balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
        System.out.println("How Much Amount Are You Want to Withdraw Rrom Account: ");
        double amount= Validation.numberValidate(1,10000,"Input Mismatch, Re Enter: ");

        if(customers.get(index).getBalance()-amount>=0){
            calculateWithdrawMoney(amount,index);

            String transactionDetails=Validation.dateAndTime()+"\nDepicted Amount -₹"+amount;
            transaction.get(customers.get(index).getAccNo()).add(transactionDetails);
            System.out.println("Your current account balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
        }
        else {
            System.out.println("Insufficient Balance...");
        }
    }
    public void depositMoney(int index){
        System.out.println("Your Current Account Balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
        System.out.println("Enter Deposit Money");
        double amount= Validation.numberValidate(1,100000,"Input Mismatch, Re Enter: ");

        if(customers.get(index).getBalance()+amount>=0){
            calculateDepositMoney(amount,index);

            String transactionDetails=Validation.dateAndTime()+"\nCredited Amount +₹"+amount;
            transaction.get(customers.get(index).getAccNo()).add(transactionDetails);
            System.out.println("Your Current Account Balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
        }
        else
            System.out.println("Balance Cannot Be Negative."+"\n");

    }
    public void moneyTransfer(int index){
        System.out.println("Your Account Balance: "+"₹"+indiaFormat.format(customers.get(index).getBalance()));
        System.out.println("Enter the Account Holder Name: ");
        String name= Validation.stringValidate(input.next());

        System.out.println("Enter Transfer Account Number: ");
        int accountNo= Validation.numberValidate(11111,100000,"Invalid Account Number, Re Enter: ");

        System.out.println("Enter Transfer Amount");
        double amount= Validation.numberValidate(1,100000,"Input Mismatch, Re Enter: ");

        if(customers.get(index).getBalance()-amount>0){
            System.out.println("Enter your Account Number: ");
            int userAccNo= Validation.numberValidate(11111,100000,"Invalid Account Number, Re Enter: ");

            System.out.println("Enter your password:");
            String userpassword= Validation.passwordValidate(input.next());

            if(customers.get(index).getAccNo()==userAccNo && customers.get(index).getPassword().equals(userpassword)){
                boolean isTransfered=true;
                for(int checking=0;checking<customers.size();checking++){
                    if(customers.get(checking).getAccNo()==accountNo){
                        if(accountNo==customers.get(index).getAccNo()){
                            System.out.println("Wrong Account Number, Please Retry!!!");
                            return;
                        }
                        calculateWithdrawMoney(amount,index);
                        calculateDepositMoney(amount,checking);

                        String transferPerson=Validation.dateAndTime()+"\nTransferred Amount to Account Number: "+accountNo+" -₹"+amount;
                        transaction.get(userAccNo).add(transferPerson);

                        String receivedPerson=Validation.dateAndTime()+"\nReceived Amount From Account Number: "+userAccNo+" +₹"+amount;
                        transaction.get(accountNo).add(receivedPerson);

                        System.out.println("Amount Successfully Transferred.");
                        isTransfered=false;
                        break;
                    }
                }
                if(isTransfered==true) {
                    System.out.println("Your Entered Wrong Account Number.\nAre You Want To Try Again..?\n1.Yes\n2.No");
                    if(Validation.numberValidate(1,2,"Input Mismatch, Re Enter: ")==1)
                        moneyTransfer(index);
                    else
                        return;
                }
            }
            else
                System.out.println("Wrong Account Number (Or) PassWord");
        }
        else
            System.out.println("You Can't Transfer Money.\nInsufficient Balance... ");
    }
   public void showTransaction(int index) {
        System.out.println("Transaction History");
        System.out.println("-------------------");
        int keyValue = customers.get(index).getAccNo();
        int size = transaction.get(keyValue).size();
        if(size==0){
            System.out.println("No Transaction History!!!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(transaction.get(keyValue).get(i)+"\n");
        }
    }

    private void calculateWithdrawMoney(double amount,int index){
        customers.get(index).setBalance(customers.get(index).getBalance()-amount);
    }
    private void calculateDepositMoney(double amount,int index){
        customers.get(index).setBalance(customers.get(index).getBalance()+amount);
    }
}
