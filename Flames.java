package AW;
import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Flames {
    public static String removeChar(String s,int i){
        StringBuilder sb=new StringBuilder(s);
        sb.deleteCharAt(i);
        return sb.toString();
    }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Boy Name : ");
            String s1=sc.nextLine().toLowerCase();
            System.out.println("Enter the Girl Name : ");
            String s2=sc.nextLine().toLowerCase();

            for(int i=0;i<s1.length();i++){
                for(int j=0;j<s2.length();j++){
                    if(s1.charAt(i)==s2.charAt(j)){
                        s1=removeChar(s1,i);
                        s2=removeChar(s2,j);
                        i--;
                        break;
                    }
                }
            }
            //System.out.println("Remaining Boy Letters: "+s1);
           // System.out.println("Remaining Girl Letters: "+s2);
            int totalNumber=Integer.parseInt(String.valueOf(s1.length()+s2.length()));
           // System.out.println(totalNumber);  this is total number of remaining words

            String s3="FLAMES";
            int k=6,l=-1;
            int y=5;
            while(k>1){
                for(int i=0;i<totalNumber;i++){
                    ++l;
                    if(l==y)
                        l=-1;
                }
                if(l==-1) {
                    s3 = removeChar(s3, y);
                    l=-1;
                }
                else {
                    s3 = removeChar(s3, l);
                    l=l-1;
                }
                k--;
                y--;
            }
           // System.out.println(s3);

            switch(s3){
                case "F":
                    System.out.println("Boy and Girls relationship: Friends");
                    break;
                case "L":
                    System.out.println("Boy and Girls relationship: Love");
                    break;
                case "A":
                    System.out.println("Boy and Girls relationship: Affection");
                    break;
                case "M":
                    System.out.println("Boy and Girls relationship: Marriage");
                    break;
                case "E":
                    System.out.println("Boy and Girls relationship: Enemy");
                    break;
                case "S":
                    System.out.println("Boy and Girls relationship: Sister");
                    break;
                default:
                    break;
            }
    }
}
