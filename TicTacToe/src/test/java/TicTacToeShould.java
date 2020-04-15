

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

    @Test
    public void give_a_Message_wich_if_the_same_player_repeat_turn(){
        MovePlayer playerMove = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION00);
        playTicTocToe.makeMove(playerMove);
        assertEquals(GameMessage.isNotYourTurn,playTicTocToe.makeMove(playerMove));

    }

    @Test
    public void give_a_Message_if_the_position_is_already_taken (){
        MovePlayer playerMove = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION00);
        MovePlayer playerMove2 = new MovePlayer(CharPlayer.CHARO,PositionPlayer.POSITION00);
        playTicTocToe.makeMove(playerMove);
        assertEquals(GameMessage.taken,playTicTocToe.makeMove(playerMove2));

    }

    @Test
    public void give_a_draw_message_when_no_one_player_win_and_the_board_is_full(){

        MovePlayer playerMove = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION00);
        MovePlayer playerMove1 = new MovePlayer(CharPlayer.CHARO,PositionPlayer.POSITION01);
        MovePlayer playerMove2 = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION02);
        MovePlayer playerMove3 = new MovePlayer(CharPlayer.CHARO,PositionPlayer.POSITION12);
        MovePlayer playerMove4 = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION10);
        MovePlayer playerMove5 = new MovePlayer(CharPlayer.CHARO,PositionPlayer.POSITION11);
        MovePlayer playerMove6 = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION21);
        MovePlayer playerMove7 = new MovePlayer(CharPlayer.CHARO,PositionPlayer.POSITION20);
        MovePlayer playerMove8 = new MovePlayer(CharPlayer.CHARX,PositionPlayer.POSITION22);

        playTicTocToe.makeMove(playerMove);
        playTicTocToe.makeMove(playerMove1);
        playTicTocToe.makeMove(playerMove2);
        playTicTocToe.makeMove(playerMove3);
        playTicTocToe.makeMove(playerMove4);
        playTicTocToe.makeMove(playerMove5);
        playTicTocToe.makeMove(playerMove6);
        playTicTocToe.makeMove(playerMove7);

        assertEquals(GameMessage.draw,playTicTocToe.makeMove(playerMove8));
    }

}
