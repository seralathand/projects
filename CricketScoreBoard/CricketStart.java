package CricketScoreBoard;

import BankProject.Validation;

import java.util.Random;
import java.util.Scanner;

class CricketStart {
    public  void start() {
        IndiaTeam india=new IndiaTeam();
        PakistanTeam p = new PakistanTeam();
        india.matchStart();

        System.out.println("Welcome To Cricket");
        System.out.println("------------------");
        System.out.println("Enter The Choice...");
        System.out.println("1-Start");
        System.out.println("2-Teams Score Table");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Choice: ");
        int choice = Validation.numberValidate(1,2,"Input Mismatch, Re Enter: ");

        switch (choice) {
            case 1:
                System.out.println("India VS Pakistan");
                Random r = new Random();
                int random = r.nextInt(2);
                System.out.println("Please Choose Head or Tail\n1-Head\n2-Tail");
                int headTail = Validation.numberValidate(1,2,"Input Mismatch, Re Enter: ");


                String result = headTail == random ? "Head" : "Tail";
                System.out.println(result.equals("Head") ? "India Win the Toss" : "Pakistan Win the Toss");
                System.out.println("Please Choose \n1-Bating\n2-Bowling");
                int batOrBowl =Validation.numberValidate(1,2,"Input Mismatch, Re Enter: ");

                String batOrBowlResult = batOrBowl == 1 ? "Bating" : "Bowling";
                System.out.println(headTail == random ? batOrBowl == 1 ? "India Choosed " + batOrBowlResult : "India Choosed " + batOrBowlResult : batOrBowl == 1 ? "Pakistan Choosed " + batOrBowlResult : "Pakistan Choosed " + batOrBowlResult);

                System.out.println("Enter The Over: \n(1 to 10)");
                int over = Validation.numberValidate(1,10,"Input Mismatch, Re Enter Between Range 1 to 10: ");

                System.out.println("\nMatch Constraints\n-1 Wicket\n-2 Wide\n1-6 Runs");
                if ((random == headTail && batOrBowl == 1) || (batOrBowl == 2)) {
                    int score = 0;
                    india.match(over, score);
                    score =IndiaTeam.indiaScore;
                    System.out.println("\n---->Target " + (score + 1) + " to Win<----" + "\n");
                    p.match(over, score);
                    System.out.println("********** Match Finished **********\n");
                } else {
                    int score = 0;
                    p.match(over, score);
                    score =PakistanTeam.pakistanScore;
                    System.out.println("\n---->Target " + (score + 1) + " to Win<----" + "\n");

                    india.match(over, score);
                    System.out.println("********** Match Finished **********\n");
                }
                india.scoreCard();
                p.pakistanScoreTable();

                System.out.println("\nIndia Team Score   : " +IndiaTeam.indiaScore+"/"+india.totalWicket);
                System.out.println("Pakistan Team Score: " +PakistanTeam.pakistanScore+"/"+p.totalWickets);
                if(IndiaTeam.indiaScore==PakistanTeam.pakistanScore)
                    System.out.println("-----> Match Draw <-----");
                else
                    System.out.println(IndiaTeam.indiaScore>PakistanTeam.pakistanScore?"~~~~~ India Won the Match ~~~~~":"~~~~~ Pakistan Won The Match ~~~~~");
                break;
            case 2:
                india.scoreCard();
                p.pakistanScoreTable();
                start();
                break;

        }
    }
}