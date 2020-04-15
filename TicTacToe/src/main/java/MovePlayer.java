public class MovePlayer {

    private CharPlayer player;
    private PositionPlayer position;

    public MovePlayer(CharPlayer playerChar, PositionPlayer playerPosition) {
        this.player = playerChar;
        this.position = playerPosition;
    }

    public void addMoveBoard(Board board,CharPlayer lastMove) {
        if (lastMove != player) {
            board.addMovePlayer(player,position);
        }
    }
}
