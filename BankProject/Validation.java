package BankProject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Validation {
   static Scanner input=new Scanner(System.in);

   public static String stringValidate(String name){
       input.nextLine();
        while(!name.matches("[a-zA-z ]+")){
            System.out.println("Input Mismatch, Re Enter: ");
            name=input.nextLine();
        }
        return name.trim();
    }

   public static int numberValidate(int startValue,int endValue,String message){
       int output=0;
        while(true) {
            try {output =Integer.parseInt (input.next());
                if (output >= startValue && output <= endValue) break;
                else throw new Exception();
            }
            catch(Exception e){System.out.println(message);
            }
        }
        return output;
    }
 public static String mobileNovalidate(String mobileNo){
     while(!mobileNo.matches("[6-9][0-9]{9}")){
         System.out.println("Input Mismatch, Re Enter Valid Mobile Number: ");
         mobileNo=input.next();
     }
     return mobileNo;
 }
 public static String emailValidate(String email){
     while(!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+
             "[a-zA-Z0-9_+&*-]+)*@" +
             "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
             "A-Z]{2,7}$")){
         System.out.println("Input Mismatch, Re Enter Valid Email Address : ");
         email=input.next();
     }
     return email;
 }
 public static String passwordValidate(String password){
     while(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")){
         System.out.println("Password Mismatch, Set Strong Password: ");
         password=input.next();
     }
     return password;
 }
    public static int numberEqualorBetween(int startValue,int endValue,int value1,int value2,int value3,String message){
        int output=0;
        while(true) {
            try {output =Integer.parseInt (input.next());
                if ((output >= startValue && output <= endValue)||output==value1||output==value2||output==value3) break;
                else throw new Exception();
            }
            catch(Exception e){System.out.println(message);
            }
        }
        return output;
    }
    static public String dateAndTime(){
       DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
       LocalDateTime now=LocalDateTime.now();
       return dtf.format(now);
    }
}
// password validation;
//                 ^           start-of-string
//            (?=.*[0-9])       # a digit must occur at least once
//            (?=.*[a-z])       # a lower case letter must occur at least once
//            (?=.*[A-Z])       # an upper case letter must occur at least once
//            (?=.*[@#$%^&+=])  # a special character must occur at least once
//            (?=\S+$)          # no whitespace allowed in the entire string
//            .{8,}             # anything, at least eight places though
//            $
