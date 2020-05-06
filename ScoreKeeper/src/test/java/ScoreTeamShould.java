import org.junit.Test;
import org.junit.Before;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTeamShould {

    ScoreKeeper scoreKeeper;

    @Before
    public void initTest(){
        scoreKeeper = new ScoreKeeper();
    }

    @Test
    public void show_Score_to_ONE_Point_To_teamA_and_Zero_points_To_TeamB(){
        scoreKeeper.scoreTeamA1();
        assertEquals("001:000", scoreKeeper.getScore());
    }

    @Test
    public void show_Score_to_TWO_Point_To_teamA_and_Zero_points_To_TeamB(){
        scoreKeeper.scoreTeamA2();
        assertEquals("002:000", scoreKeeper.getScore());
    }

    @Test
    public void show_Score_to_THREE_Point_To_teamA_and_Zero_points_To_TeamB(){
        scoreKeeper.scoreTeamA3();
        assertEquals("003:000", scoreKeeper.getScore());
    }

    @Test
    public void show_Score_to_ONE_Point_To_teamB_and_Zero_points_To_TeamA(){
        scoreKeeper.scoreTeamB1();
        assertEquals("000:001", scoreKeeper.getScore());
    }

    @Test
    public void show_Score_to_TWO_Point_To_teamB_and_Zero_points_To_TeamA(){
        scoreKeeper.scoreTeamB2();
        assertEquals("000:002", scoreKeeper.getScore());
    }

    @Test
    public void show_Score_to_THREE_Point_To_teamB_and_Zero_points_To_TeamA(){
        scoreKeeper.scoreTeamB3();
        assertEquals("000:003", scoreKeeper.getScore());
    }

    @Test
    public void check_Format_Two_Digits_show_Score_to_TEN_Point_To_teamA_and_TWENTY_points_To_TeamA(){

        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamA3();

        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamB2();

        assertEquals("010:020", scoreKeeper.getScore());
    }

    @Test
    public void check_Format_THREE_Digits_show_Score_to_HOUNDRED_Point_To_teamA_and_HOUNDRED_points_To_TeamA(){

        for (int indice = 1; indice <= 10; indice ++){
            scoreKeeper.scoreTeamA1();
            scoreKeeper.scoreTeamA2();
            scoreKeeper.scoreTeamA3();
            scoreKeeper.scoreTeamA3();
            scoreKeeper.scoreTeamA1();

            scoreKeeper.scoreTeamB1();
            scoreKeeper.scoreTeamB1();
            scoreKeeper.scoreTeamB3();
            scoreKeeper.scoreTeamB3();
            scoreKeeper.scoreTeamB2();
        }

        assertEquals("100:100", scoreKeeper.getScore());
    }




}
