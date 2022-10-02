package BankProject;

public class CustomerDetails {
    private int accNo;
    private String password;
    private String name;
    private int age;
    private String phoneNo;
    private double balance;
    private String email;

    static int count=11111;
    CustomerDetails(String password,String name,String phoneNo,String email,int age,double balance){
        this.accNo=count++;
        this.password=password;
        this.name=name;
        this.phoneNo=phoneNo;
        this.age=age;
        this.balance=balance;
        this.email=email;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
