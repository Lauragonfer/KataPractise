import java.util.Date;

public class TaskTodo {

    private int id;
    private String name;
    private StatusTask status;
    private String date;
    private SubTaskList subTasklist;

    public TaskTodo(String name, int id) {
        this.id =id;
        this.name = name;
        this.status = StatusTask.KO;
        this.date = "20-04-2020";
        this.subTasklist = new SubTaskList();
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

    public boolean isTaskCompleted() {
        if (status.equals(status.OK)){
            return true;
        }
        return false;
    }


    public Message addDaugther(int idDaugther, String name) {
        TaskTodo subTask = new TaskTodo(name,idDaugther);
        return subTasklist.addSubTask(subTask);


    }

    public boolean hasSubtask() {
        if (!subTasklist.isEmpty()){
            return true;
        }
        return false;
    }

    public String addPrintSubTask() {
        return  subTasklist.toString();
        }

    @Override
    public String toString() {
        return  "id: " + id + "\n" + "Task: " + name + "\n" + "Status: " + status.status + "\n" + "Due: " + date +"\n" ;
    }
}
