package CricketScoreBoard;

public class DetailsOfBatsMan {
    private int six=0;
    private int four=0;
    private int totalBalls=0;
    private int runs=0;
    private int totalRuns=0;
    private String name="";
    private String status="-";
    private int wickets=0;


    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets += wickets;
    }

    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setSix(int six){
        this.six+=six;
    }
    public int getSix(){
        return six;
    }
    public void setFour(int four){
        this.four+=four;
    }
    public int getFour(){
        return four;
    }
    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls += totalBalls;
    }

    public void setRuns(int run){
        this.runs=run;
    }
    public int getRuns(){
        return runs;
    }
    public void setTotalRuns(int totalRuns){
        this.totalRuns+=totalRuns;
    }
    public int getTotalRuns(){
        return totalRuns;
    }
}
