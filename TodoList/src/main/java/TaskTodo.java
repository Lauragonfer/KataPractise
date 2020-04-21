import java.util.Objects;

public class TaskTodo {

    private TaskId id;
    private TaskName name;
    private StatusTask status;
    private TaskDate date;
    private SubTaskList subTasklist;

    public TaskTodo(String name, int id) {
        this.id = new TaskId(id);
        this.name = TaskName.createTaskName(name);
        this.status = StatusTask.KO;
        this.date = new TaskDate();
        this.subTasklist = new SubTaskList();
    }

    public Message completedFatherTask() {

        if(subTasklist.areAllCompleted()){
            this.status = StatusTask.OK;
            return Message.markAsCompleted;
        }
    return Message.someSubTaskAreIncomplete;
    }

    public Message completedSubTask() {
        this.status = StatusTask.OK;
        return Message.markAsCompletedSubTask;
    }

    public boolean isIdEquals(int id) {
        if (this.id.equals(new TaskId(id))){
            return true;
        }
        return false;
    }

    public boolean isTaskCompleted() {
        if (status.equals(StatusTask.OK)){
            return true;
        }
        return false;
    }


    public Message addDaugther(int idDaugther, String name) {
        TaskTodo subTask = new TaskTodo(name,idDaugther);
        return subTasklist.addSubTask(new TaskId(idDaugther),subTask);


    }

    public Message markSubTaskAsComplete(int idDaughter) {
        return subTasklist.subTaskCompleted(idDaughter);
    }

    public boolean hasSubtask() {
        if (!subTasklist.isEmptySubtaskMap()){
            return true;
        }
        return false;
    }

    public String addPrintSubTask() {
        return  subTasklist.toString();
        }

    @Override
    public String toString() {
        return  "id: " + id.toString() + "\n" + "Task: " + name.toString() + "\n" + "Status: " + status.status + "\n" + "Due: " + date.toString() +"\n" ;
    }
}

class  TaskId {
    int id;

    public TaskId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskId taskId = (TaskId) o;
        return id == taskId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class  TaskName {

    String name;

    private TaskName(String nameTask) {
        this.name = nameTask;
    }

    public static TaskName createTaskName(String nameTask) {
        if(!nameTask.matches("[a-zA-Z0-9 ]+") || nameTask.length() < 5 || nameTask.length() >20)
        {
            throw new InvalidNameException(Message.invalidNameTask.message);
        }
        return new TaskName(nameTask);
    }

    @Override
    public String toString() {
        return  name ;
    }
}

class TaskDate{

    String date;

    public TaskDate() {
        this.date = "20-04-2020";
    }

    @Override
    public String toString() {
        return date;
    }
}
