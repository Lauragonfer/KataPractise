public enum Message {

    addTaskOk("Correct Adding task"),
    invalidNameTask("Invalid Name Task only characters between A-Z and 0-9");

    public final String message;

    Message (String message){this.message = message;}
}
