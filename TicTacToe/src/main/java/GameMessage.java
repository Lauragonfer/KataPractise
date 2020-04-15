public enum GameMessage {

    turnO ("TURN O"),
    turnX ("TURN X"),
    isNotYourTurn("Is not your turn"),
    win ("You WIN"),
    taken ("Position already Taken"),
    draw ("DRAW");

    public final String message;

    GameMessage(String message){
        this.message = message;
    }
}
