import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Board {


    private HashMap<PositionPlayer,CharPlayer> board = new HashMap<PositionPlayer, CharPlayer>(){{
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

    public Board() {
    }

    public Board(HashMap<PositionPlayer, CharPlayer> board) {
        this.board = board;
    }

    public void addMovePlayer(CharPlayer player,PositionPlayer positionPlayer ) {

        if ((board.get(positionPlayer)) == CharPlayer.EMPTY) {
            board.put(positionPlayer, player);
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                '}';
    }
}
