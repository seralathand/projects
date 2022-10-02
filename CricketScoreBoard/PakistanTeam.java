package CricketScoreBoard;

import BankProject.Validation;

public class PakistanTeam extends Teams_Players {
    int totalWickets=0;
    int straiker=0;
    int bowlers[]={7,8,9,10};

     static int pakistanScore=0;
        boolean scoreStatus=true;
        boolean noBall=true;
    public void match(int over,int score){
        System.out.println("\nPakistan Batting");
        System.out.println("------------------");
            for(int i=0;i<over;i++){
                System.out.println("Choose India Bowler....");
                System.out.println("1-"+india[bowlers[0]]);
                System.out.println("2-"+india[bowlers[1]]);
                System.out.println("3-"+india[bowlers[2]]);
                System.out.println("4-"+india[bowlers[3]]);
                int chooseBowler=Validation.numberValidate(1,4,"Input Mismatch, Re Select the Bowler: ")-1;

                for(int j=1;j<=6;j++) {
                    if (temp == 12) break;

                    System.out.println("\nOver " + j + " Ball " + i + "." + j);
                        int run = Validation.numberEqualorBetween(0,6,-1,-2,-3,"Input Mismatch, Please Follow Match constraints: ");

                        if (run >= -1 && run <= 6) {
                            if(noBall==false){
                                if(run==-1) {
                                    System.out.println("Not Out");
                                    noBall=true;
                                    continue;
                                }
                            }
                            //for straik change
                            switch (straiker) {
                                case 0:
                                    first(run, chooseBowler);
                                    break;
                                case 1:
                                    second(run, chooseBowler);
                                    break;
                            }
                        } else {

                            if(run==-2){
                                pakistanScore+=1;
                                System.out.println("----Wide----");
                            }
                            else if(run==-3){
                                pakistanScore+=1;
                                System.out.println("-->No Ball\n---Free Git---");
                                noBall=false;
                            }
                            j=j-1;
                            continue;
                        }

                        if(run>=1&&run<=6)
                        pakistanScore+=run;
                        if(score!=0){
                        if(score<pakistanScore){ scoreStatus=false;break;}}
                }
                if(temp==12)break;
                straiker=straiker==1?0:1;
                if(scoreStatus==false) break;
            }
        }


        int batsMan[]= {0,1};
        int temp=2;
        public void first(int run,int chooseBowler){
            pakistanTeam.get(batsMan[0]).setTotalBalls(1);

            if(run==-1) {
                pakistanTeam.get(batsMan[0]).setStatus("Out");
                straikerInfo(1);
                indiaTeam.get(bowlers[chooseBowler]).setWickets(1);
                batsMan[0]=temp;
                temp++;
                totalWickets++;
                return;
            }
            if(run==4) {
                pakistanTeam.get(batsMan[0]).setFour(1);
                pakistanTeam.get(batsMan[0]).setTotalRuns(run);
            }
            else if(run==6) {
                pakistanTeam.get(batsMan[0]).setSix(1);
                pakistanTeam.get(batsMan[0]).setTotalRuns(run);
            }
            else if(run%2!=0) {
                pakistanTeam.get(batsMan[0]).setTotalRuns(run);
                straiker = 1;
            }
            else
                pakistanTeam.get(batsMan[0]).setTotalRuns(run);
            straikerInfo(1);
        }
        public void second(int run,int chooseBowler) {
            pakistanTeam.get(batsMan[1]).setTotalBalls(1);

            if(run==-1) {
                pakistanTeam.get(batsMan[1]).setStatus("Out");
                straikerInfo(2);
               // indiaTeam.get(bowlers[chooseBowler]).setThrowedBalls(1);
                indiaTeam.get(bowlers[chooseBowler]).setWickets(1);
                batsMan[1]=temp;
                temp++;
                totalWickets++;
                return;
            }
            if (run == 4) {
                pakistanTeam.get(batsMan[1]).setFour(1);
                pakistanTeam.get(batsMan[1]).setTotalRuns(run);
            }
            else if (run == 6){
                pakistanTeam.get(batsMan[1]).setSix(1);
                pakistanTeam.get(batsMan[1]).setTotalRuns(run);
            }
            else if(run%2!=0) {
                straiker = 0;
                pakistanTeam.get(batsMan[1]).setTotalRuns(run);
            }
            else
                pakistanTeam.get(batsMan[1]).setTotalRuns(run);
            straikerInfo(2);
        }
        public void pakistanScoreTable(){
            System.out.println("Pakistan Team Score Table");
            System.out.println("-------------------------");
            System.out.printf("%-20s%-12s%-10s%-10s%-10s%-10s%-15s%-10s\n","Players Name","Status","F","S",
                "R","B","S&R","W");
        for(int i=0;i<11;i++) {
            double strikeValue=(pakistanTeam.get(i).getTotalRuns()/100)*pakistanTeam.get(i).getTotalBalls();
            System.out.printf("%-20s%-12s%-10d%-10d%-10d%-10d%-15f%-10d\n", pakistanTeam.get(i).getName(),
                    pakistanTeam.get(i).getStatus(), pakistanTeam.get(i).getFour(),
                    pakistanTeam.get(i).getSix(), pakistanTeam.get(i).getTotalRuns(), pakistanTeam.get(i).getTotalBalls(),
                    strikeValue,pakistanTeam.get(i).getWickets());

        }
    }
    void straikerInfo(int value){
            if(value==1){
                System.out.println("-->"+pakistanTeam.get(batsMan[0]).getName()+":  "+pakistanTeam.get(batsMan[0]).getTotalRuns()+
                        "("+pakistanTeam.get(batsMan[0]).getTotalBalls()+")"+"  "+pakistanTeam.get(batsMan[0]).getStatus());
                System.out.println("   "+pakistanTeam.get(batsMan[1]).getName()+":  "+pakistanTeam.get(batsMan[1]).getTotalRuns()+
                        "("+pakistanTeam.get(batsMan[1]).getTotalBalls()+")"+"  "+pakistanTeam.get(batsMan[1]).getStatus());
            }
            else{
                System.out.println("   "+pakistanTeam.get(batsMan[0]).getName()+":  "+pakistanTeam.get(batsMan[0]).getTotalRuns()+
                        "("+pakistanTeam.get(batsMan[0]).getTotalBalls()+")"+"  "+pakistanTeam.get(batsMan[0]).getStatus());
                System.out.println("-->"+pakistanTeam.get(batsMan[1]).getName()+": "+pakistanTeam.get(batsMan[1]).getTotalRuns()+
                        "("+pakistanTeam.get(batsMan[1]).getTotalBalls()+")"+"  "+pakistanTeam.get(batsMan[1]).getStatus());
            }
    }
    }

