public class PlayTicTocToe {

    private Board board;
    private CharPlayer lastPlayer = CharPlayer.CHARO;

    public PlayTicTocToe(Board board) {
        this.board = board;
    }

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

    public String ShowBoard() {
        return board.toString();
    }
}
