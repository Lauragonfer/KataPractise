import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<TaskTodo> todoListTasks;

    public TodoList() {
        this.todoListTasks = new ArrayList<TaskTodo>();
    }


    public Message addTask(String name,int id) {
        todoListTasks.add(new TaskTodo(name,id));
        return Message.addTaskOk;
    }

    public Message markTaskAsCompleted(int id) {
        TaskTodo task = retrieveTaskByID(id);
        if(task == null)
        {
            return Message.taskNotFound;
        }
        return task.completedTask();
    }

    private TaskTodo retrieveTaskByID(int id) {
        for (TaskTodo task: todoListTasks) {
            if(task.isIdEquals(id)){
                return task;
            }
        }
        return null;
    }

    public String printToDoList() {
        String formatTaskList= "";
        for (TaskTodo task: todoListTasks) {
            formatTaskList = task.toString();
        }
        return formatTaskList;
    }

    public String printCompletedtask() {
        String formatTaskList= "";
        for (TaskTodo task: todoListTasks) {
            if (task.isTaskCompleted()){
                formatTaskList = task.toString();
            }
        }
        return formatTaskList;
    }

    public String printIncompleteTask() {
        String formatTaskList= "";
        for (TaskTodo task: todoListTasks) {
            if (!task.isTaskCompleted()){
                formatTaskList = task.toString();
            }
        }
        return formatTaskList;
    }
}
