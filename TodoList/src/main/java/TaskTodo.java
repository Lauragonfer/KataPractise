import java.util.Date;

public class TaskTodo {

    private int id;
    private String name;
    private StatusTask status;
    private String date;

    public TaskTodo(String name, int id) {
        this.id =id;
        this.name = name;
        this.status = StatusTask.KO;
        this.date = "20-04-2020";
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

    @Override
    public String toString() {
        return  "id: " + id + "\n" + "Task: " + name + "\n" + "Status: " + status.status + "\n" + "Due: " + date +"\n" ;
    }

    public boolean isTaskCompleted() {
        if (status.equals(status.OK)){
            return true;
        }
        return false;
    }
}
