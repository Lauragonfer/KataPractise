import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameAcceptanceTest {

    @Test
    public void bowlingGameAcceptanceTest(){
        Game bowlingGame = new Game();

        for (int indice = 1; indice <= 10; indice ++){
            bowlingGame.roll(4);
            bowlingGame.roll(2);
        }
        assertEquals(60,bowlingGame.score());
    }


}
