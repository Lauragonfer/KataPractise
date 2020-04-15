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

    public GameMessage addMovePlayer(CharPlayer player,PositionPlayer positionPlayer ) {

        if ((board.get(positionPlayer)) == CharPlayer.EMPTY) {
            board.put(positionPlayer, player);
            return stateGameBoard(player);
        }
        return GameMessage.taken;
    }

    private  GameMessage stateGameBoard(CharPlayer player){
        if (isDraw()){
            return GameMessage.draw;
        }
        if(isWinner())
        {
            return GameMessage.win;
        }
        return messageNextTurn(player);
    }

    public GameMessage messageNextTurn(CharPlayer player) {
        if(player.equals(CharPlayer.CHARX)){
            return  GameMessage.turnO;
        }
        return  GameMessage.turnX;
    }

    private boolean isDraw() {
        return !board.containsValue(CharPlayer.EMPTY);
    }

    private boolean isWinner (){
        if(winHorizontal() || winVertical() || winDiagonal())
        {
            return true;
        }
        return false;
    }

    private boolean winDiagonal() {
        if (board.get(PositionPlayer.POSITION00).equals(board.get(PositionPlayer.POSITION11))
                && board.get(PositionPlayer.POSITION22).equals(board.get(PositionPlayer.POSITION00)) )
        {
            return true;
        }
        if (board.get(PositionPlayer.POSITION02).equals(board.get(PositionPlayer.POSITION11))
                && board.get(PositionPlayer.POSITION20).equals(board.get(PositionPlayer.POSITION02)) )
        {
            return true;
        }
        return false;
    }

    private boolean winVertical( ) {

        if (board.get(PositionPlayer.POSITION00).equals(board.get(PositionPlayer.POSITION10))
                && board.get(PositionPlayer.POSITION20).equals(board.get(PositionPlayer.POSITION00)) )
        {
            return true;
        }
        if (board.get(PositionPlayer.POSITION01).equals(board.get(PositionPlayer.POSITION11))
                && board.get(PositionPlayer.POSITION21).equals(board.get(PositionPlayer.POSITION01)) )
        {
            return true;
        }
        if (board.get(PositionPlayer.POSITION02).equals(board.get(PositionPlayer.POSITION12))
                && board.get(PositionPlayer.POSITION22).equals(board.get(PositionPlayer.POSITION02)) )
        {
            return true;
        }
        return false;
    }

    private boolean winHorizontal() {

        if (board.get(PositionPlayer.POSITION00).equals(board.get(PositionPlayer.POSITION10))
                && board.get(PositionPlayer.POSITION02).equals(board.get(PositionPlayer.POSITION00)) )
        {
            return true;
        }
        if (board.get(PositionPlayer.POSITION10).equals(board.get(PositionPlayer.POSITION11))
                && board.get(PositionPlayer.POSITION12).equals(board.get(PositionPlayer.POSITION10)) )
        {
            return true;
        }
        if (board.get(PositionPlayer.POSITION20).equals(board.get(PositionPlayer.POSITION21))
                && board.get(PositionPlayer.POSITION22).equals(board.get(PositionPlayer.POSITION20)) )
        {
            return true;
        }
        return false;
    }

}
