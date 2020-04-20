import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<TaskTodo> todoListTasks;

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
}
