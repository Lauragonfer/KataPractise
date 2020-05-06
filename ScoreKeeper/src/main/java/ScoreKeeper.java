
public class ScoreKeeper {

    private int scoreTeamA;
    private int scoreTeamB;
    private FormatScore format;

    public ScoreKeeper() {
        this.scoreTeamA = 0;
        this.scoreTeamB = 0;
        this.format = new FormatScore();
    }


    void scoreTeamA1(){
       scoreTeamA += Score.ONE.score;
    }
    void scoreTeamA2(){
        scoreTeamA += Score.TWO.score;
    }
    void scoreTeamA3(){
        scoreTeamA += Score.THREE.score;
    }
    void scoreTeamB1(){
        scoreTeamB += Score.ONE.score;
    }
    void scoreTeamB2(){
        scoreTeamB += Score.TWO.score;
    }
    void scoreTeamB3(){
        scoreTeamB += Score.THREE.score;
    }

    String getScore(){
        return format.formatScoreString(scoreTeamA,scoreTeamB);
    }

}
