import java.util.Date;

public class TaskTodo {

    private String name;
    private StatusTask status;
    private Date date;

    public TaskTodo(String name) {
        this.name = name;
        this.status = StatusTask.KO;
        this.date = new Date();
    }
}
