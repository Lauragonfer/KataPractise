
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTeamAcceptantTest {

    @Test
    public void scoreKeeperAcceptanceTest(){
        ScoreKeeper scoreKeeper = new ScoreKeeper();

        for(int indice = 1;indice <= 10;indice++){
            scoreKeeper.scoreTeamA1();
            scoreKeeper.scoreTeamA1();
            scoreKeeper.scoreTeamA2();
            scoreKeeper.scoreTeamA3();
            scoreKeeper.scoreTeamA3();

            scoreKeeper.scoreTeamB1();
            scoreKeeper.scoreTeamB1();
            scoreKeeper.scoreTeamB2();
            scoreKeeper.scoreTeamB2();
            scoreKeeper.scoreTeamB3();
            scoreKeeper.scoreTeamB3();
        }

        assertEquals("100:120", scoreKeeper.getScore());
    }
}
