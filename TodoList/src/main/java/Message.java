public enum Message {

    addTaskOk("Correct Adding Task"),
    addSubTaskOk("Correct Adding SubTask"),
    invalidNameTask("Invalid Name Task only characters between A-Z and 0-9"),
    markAsCompleted("Task Mark as completed"),
    markAsCompletedSubTask("SubTask Mark as completed"),
    taskNotFound("Task id not exist"),
    subTaskNotFound("SubTask id not exist"),
    someSubTaskAreIncomplete("Can not completed because some Subtask are not completed yet"),
    fatherTaskNotFound("Father task of this subtask not Exist");

    public final String message;

    Message (String message){this.message = message;}
}
