package BankProject;
import java.text.NumberFormat;
import java.util.*;

class NewCustomer {
    static List<CustomerDetails> customers=new ArrayList<>();
    static HashMap<Integer,List<String>> transaction=new HashMap<>();
    NumberFormat indiaFormat=NumberFormat.getInstance(new Locale("en","IN"));

    Scanner input=new Scanner(System.in);
    int user=0;
   public void creatAccount(){
       System.out.println("Please Register Your Details:-");
       System.out.println("-----------------------------");
        System.out.println("Enter your Name: ");
        String name= Validation.stringValidate(input.nextLine().trim());

       System.out.println("Enter Your Age: ");
       byte age= (byte) Validation.numberValidate(18,50,"Age Should Be 18-50, Re Enter: ");

        System.out.println("Enter your Mobile Number: ");
        String mobileNo= Validation.mobileNovalidate(input.next());

        System.out.println("Enter your Email Address");
        String email= Validation.emailValidate(input.next());

        System.out.println("Set Your Password: ");
       String password= Validation.passwordValidate(input.next());

        System.out.println("Enter Minimum Amount Rs.500 : ");
        int balance=Validation.numberValidate(400,100000,"Minimum Amount Should Be Above Rs.400, Re Enter: ");
        if(checkSame(email,mobileNo)==false)
            return;
        customers.add(new CustomerDetails(password,name,mobileNo,email,age,balance));
        transaction.put(customers.get(user).getAccNo(),new LinkedList<>());
        System.out.println("Account Sucessfully Created.");
        user++;
        profile();
    }
  private void profile(){
       System.out.println("-----------------------------------");
       System.out.println("Account Number : "+customers.get(user-1).getAccNo());
       System.out.println("Account Balance:"+"₹"+indiaFormat.format(customers.get(user-1).getBalance()));
       System.out.println("Name           : "+customers.get(user-1).getName());
       System.out.println("Email Address  : "+customers.get(user-1).getEmail());
       System.out.println("Contact Number : "+customers.get(user-1).getPhoneNo());
       System.out.println("Age            : "+customers.get(user-1).getAge());
       System.out.println("-----------------------------------");
    }
    public boolean checkSame(String email,String mobile) {
        for (int user = 0; user < customers.size(); user++) {
            if (customers.get(user).getEmail().equals(email) || customers.get(user).getPhoneNo().equals(mobile)) {
                System.out.println("Your Account Already Exit.");
                return false;
            }
        }
        return true;
    }
}
