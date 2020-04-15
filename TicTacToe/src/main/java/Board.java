
import java.util.HashMap;

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

    public GameMessage addMovePlayer(CharPlayer player,PositionPlayer positionPlayer ) {

        if ((board.get(positionPlayer)) == CharPlayer.EMPTY) {
            board.put(positionPlayer, player);
            if (isDraw()){
                return GameMessage.draw;
            }
            return messageNextTurn(player);
        }
        return GameMessage.taken;
    }

    private boolean isDraw() {
        return !board.containsValue(CharPlayer.EMPTY);
    }

    public GameMessage messageNextTurn(CharPlayer player) {
        if(player.equals(CharPlayer.CHARX)){
            return  GameMessage.turnO;
        }
        return  GameMessage.turnX;
    }

    private boolean isWin (){
     return false;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + board +
                '}';
    }
}
