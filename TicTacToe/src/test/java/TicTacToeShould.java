

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class TicTacToeShould {

    PlayTicTocToe playTicTocToe ;
    HashMap<PositionPlayer, CharPlayer> boardMapExpected;

    @BeforeEach
    public void initTest() {

        playTicTocToe = new PlayTicTocToe();
        boardMapExpected = new HashMap<PositionPlayer, CharPlayer>() {{
            put(PositionPlayer.POSITION00, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION01, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION02, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION10, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION11, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION12, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION20, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION21, CharPlayer.EMPTY);
            put(PositionPlayer.POSITION22, CharPlayer.EMPTY);
        }};
    }

    @Test
    public  void check_if_the_first_move_is_X_And_add_Move_To_the_board(){

        MovePlayer playerMove = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION00);
        playTicTocToe.makeMove(playerMove);

        boardMapExpected.put(PositionPlayer.POSITION00,CharPlayer.CHARX);
        Board boardExpected = new Board (boardMapExpected);

        PlayTicTocToe playTicTocToeExpected = new PlayTicTocToe(boardExpected);

        assertEquals(playTicTocToeExpected.ShowBoard(),playTicTocToe.ShowBoard());
    }

}
