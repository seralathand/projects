package CricketScoreBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class Teams_Players {
    Scanner input =new Scanner(System.in);

   static ArrayList<DetailsOfBatsMan> indiaTeam=new ArrayList<>();
    static ArrayList<DetailsOfBatsMan> pakistanTeam=new ArrayList<>();


    static String india[]={"Rohit sharma","virat koli","K L Rahul","SuriyaKumar",
        "Rishabh Pant","Harthick Pandiya","Ravindra jadeja",
        "Jasprit Bumrah","Mohemmed Shami","Jagal","Buvanesvar"};
    static String pakistan[]={"Babar Azam","Mohammad Rizwan","Fakhar Zaman","Mohammad Nawaz",
        "Shadab Khan","Asif Ali","Hafeez","Haider Ali","Hasan Ali",
        "Haider patel","Naseem"};

    public  void matchStart(){
        for(int index=0;index<india.length;index++){
            indiaTeam.add(new DetailsOfBatsMan());
            indiaTeam.get(index).setName(india[index]);
            pakistanTeam.add( new DetailsOfBatsMan());
            pakistanTeam.get(index).setName(pakistan[index]);
        }
    }


   }
