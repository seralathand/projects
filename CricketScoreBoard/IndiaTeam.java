package CricketScoreBoard;

import BankProject.Validation;


public class IndiaTeam extends Teams_Players {

    int totalWicket=0;
    int straiker = 0;
    int bowlers[] = {7, 8, 9, 10};

    static int indiaScore=0;
    boolean scoreStatus=true;
    boolean noBall=true;
    public void match (int  over,int score) {
        System.out.println("\nIndia Batting");
        System.out.println("---------------");
        for (int i = 0; i < over; i++) {
            System.out.println("* Choose Pakistan Bowler....");
            System.out.println("1-" + pakistan[bowlers[0]]);
            System.out.println("2-" + pakistan[bowlers[1]]);
            System.out.println("3-" + pakistan[bowlers[2]]);
            System.out.println("4-" + pakistan[bowlers[3]]);
            int chooseBowler = Validation.numberValidate(1,4,"Input Mismatch, Re Select the Bowler: ")-1;

            for (int j = 1; j <= 6; j++) {
                if (temp == 12) break;
                System.out.println("\nOver " + j + " Ball " + i + "." + j);
                int run = Validation.numberEqualorBetween(0,6,-1,-2,-3,"Input Mismatch, Please Follow Match constraints: ");

                if (run >=-1 && run <= 6) {
                    //for straik change
                    if(noBall==false){
                        if(run==-1){
                            System.out.println("---Not Out---");
                            noBall=true;
                            continue;
                        }
                    }
                    switch (straiker) {
                        case 0:
                            first(run, chooseBowler);
                            break;
                        case 1:
                            second(run, chooseBowler);
                            break;
                    }
                }
                else {
                    if(run==-2){
                        indiaScore+=1;
                        System.out.println("----Wide----");
                    }
                    else if(run==-3){
                        System.out.println("-->No Ball\n---Free Git---");
                        indiaScore+=1;
                        noBall=false;
                    }
                    j = j - 1;
                    continue;
                }
                if(run >=1 && run <= 6)
                    indiaScore+=run;
                if(score!=0){
                    if(score<indiaScore){
                        scoreStatus=false;
                        break;}
                }
            }
            if (temp == 12) break;
            straiker = straiker == 1 ? 0 : 1;
            if(scoreStatus==false)break;
        }
    }


    int batsMan[] = {0, 1};
    int temp = 2;
    public void first ( int run, int chooseBowler){
        indiaTeam.get(batsMan[0]).setTotalBalls(1);

        if (run == -1) {
            indiaTeam.get(batsMan[0]).setStatus("Out");
            straikerInfo(1);
            pakistanTeam.get(bowlers[chooseBowler]).setWickets(1);
            batsMan[0] = temp;
            temp++;
            totalWicket++;
            return;
        }

        if (run == 4) {
            indiaTeam.get(batsMan[0]).setFour(1);
            indiaTeam.get(batsMan[0]).setTotalRuns(run);
        } else if (run == 6) {
            indiaTeam.get(batsMan[0]).setSix(1);
            indiaTeam.get(batsMan[0]).setTotalRuns(run);
        } else if (run % 2 != 0) {
            indiaTeam.get(batsMan[0]).setTotalRuns(run);
            straiker = 1;
        }
        else
            indiaTeam.get(batsMan[0]).setTotalRuns(run);
        straikerInfo(1);
    }
    public void second ( int run, int chooseBowler){
        indiaTeam.get(batsMan[1]).setTotalBalls(1);

        if (run == -1) {
            indiaTeam.get(batsMan[1]).setStatus("Out");
            straikerInfo(2);
            pakistanTeam.get(bowlers[chooseBowler]).setWickets(1);
            batsMan[1] = temp;
            temp++;
            totalWicket++;
            return;
        }
        if (run == 4) {
            indiaTeam.get(batsMan[1]).setFour(1);
            indiaTeam.get(batsMan[1]).setTotalRuns(run);
        } else if (run == 6) {
            indiaTeam.get(batsMan[1]).setSix(1);
            indiaTeam.get(batsMan[1]).setTotalRuns(run);
        } else if (run % 2 != 0) {
            straiker = 0;
            indiaTeam.get(batsMan[1]).setTotalRuns(run);
        }
        else
            indiaTeam.get(batsMan[1]).setTotalRuns(run);
        straikerInfo(2);
    }
    void straikerInfo(int value){
        if(value==1){
            System.out.println("-->"+indiaTeam.get(batsMan[0]).getName()+":  "+indiaTeam.get(batsMan[0]).getTotalRuns()+"("+indiaTeam.get(batsMan[0]).getTotalBalls()+")"+" "+indiaTeam.get(batsMan[0]).getStatus());
            System.out.println("   "+indiaTeam.get(batsMan[1]).getName()+":  "+indiaTeam.get(batsMan[1]).getTotalRuns()+"("+indiaTeam.get(batsMan[1]).getTotalBalls()+")"+" "+indiaTeam.get(batsMan[1]).getStatus());
        }
        else{
            System.out.println("   "+indiaTeam.get(batsMan[0]).getName()+":  "+indiaTeam.get(batsMan[0]).getTotalRuns()+"("+indiaTeam.get(batsMan[0]).getTotalBalls()+")"+" "+indiaTeam.get(batsMan[0]).getStatus());
            System.out.println("-->"+indiaTeam.get(batsMan[1]).getName()+":   "+indiaTeam.get(batsMan[1]).getTotalRuns()+"("+indiaTeam.get(batsMan[1]).getTotalBalls()+")"+" "+indiaTeam.get(batsMan[1]).getStatus());
        }
    }
    public void scoreCard(){
        System.out.println(" Indian Team Score Table ");
        System.out.println("-------------------------");
        System.out.printf("%-20s%-12s%-10s%-10s%-10s%-10s%-15s%-10s\n","Players Name","Status","F",
                "S","R","B","S&T","W");
        for(int i=0;i<11;i++){
            double strikeValue=(indiaTeam.get(i).getTotalRuns()/100)*indiaTeam.get(i).getTotalBalls();
            System.out.printf("%-20s%-12s%-10d%-10d%-10d%-10d%-15f%-10d\n",indiaTeam.get(i).getName(),
                    indiaTeam.get(i).getStatus(),indiaTeam.get(i).getFour(),
                    indiaTeam.get(i).getSix(),indiaTeam.get(i).getTotalRuns(),indiaTeam.get(i).getTotalBalls(),strikeValue,indiaTeam.get(i).getWickets());
        }
        System.out.println();
    }
}
