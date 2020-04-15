import java.util.List;

public class PlayTicTocToe {

    private Board board;
    private CharPlayer lastMove = CharPlayer.CHARO;

    public PlayTicTocToe(Board board) {
        this.board = board;
    }

    public PlayTicTocToe() {
        this.board = new Board();
    }

    public void makeMove(MovePlayer movePlayer) {
        movePlayer.addMoveBoard(board,lastMove);
    }

    public String ShowBoard() {
        return board.toString();
    }
}
