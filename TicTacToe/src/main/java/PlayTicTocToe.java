public class PlayTicTocToe {

    private Board board;
    private CharPlayer lastPlayer = CharPlayer.CHARO;

    public PlayTicTocToe() {
        this.board = new Board();
    }

    public GameMessage makeMove(MovePlayer movePlayer) {

        if(!movePlayer.isTheSamePlayer(lastPlayer)){
            lastPlayer = movePlayer.changeLastPlayer();
            return movePlayer.addMoveBoard(board);
        }
        return GameMessage.isNotYourTurn;
    }

}
