import java.util.Date;

public class TaskTodo {

    private int id;
    private String name;
    private StatusTask status;
    private Date date;

    public TaskTodo(String name, int id) {
        this.id =id;
        this.name = name;
        this.status = StatusTask.KO;
        this.date = new Date();
    }

    public Message completedTask() {
        this.status = StatusTask.OK;
        return Message.markAsCompleted;
    }

    public boolean isIdEquals(int id) {
        if (this.id == id){
            return true;
        }
        return false;
    }
}
