public class MovePlayer {

    private CharPlayer player;
    private PositionPlayer position;

    public MovePlayer(CharPlayer playerChar, PositionPlayer playerPosition) {
        this.player = playerChar;
        this.position = playerPosition;
    }

    public GameMessage addMoveBoard(Board board) {

          return  board.addMovePlayer(player,position);
    }

    public boolean isTheSamePlayer(CharPlayer lastPlayer){
        if (lastPlayer != player) {
           return false;
        }
        return true;
    }

    public CharPlayer changeLastPlayer() {
        return player;
    }


}
