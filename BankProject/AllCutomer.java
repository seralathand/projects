package BankProject;

public class AllCutomer extends NewCustomer{
    public void showAccount(){
        for(int user=0;user<customers.size();user++){
            System.out.println("-----------------------------------");
            System.out.println("Account Number : "+customers.get(user).getAccNo());
            System.out.println("Account Balance:"+"₹"+indiaFormat.format(customers.get(user).getBalance()));
            System.out.println("Name           : "+customers.get(user).getName());
            System.out.println("Email Address  : "+customers.get(user).getEmail());
            System.out.println("Contact Number : "+customers.get(user).getPhoneNo());
            System.out.println("Age            : "+customers.get(user).getAge());
            System.out.println("-----------------------------------");
        }
    }
}
