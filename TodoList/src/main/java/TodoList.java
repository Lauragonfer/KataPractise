import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<TaskTodo> todoListTasks;

    public TodoList() {
        this.todoListTasks = new ArrayList<TaskTodo>();
    }


    public Message addTask(String name) {
        todoListTasks.add(new TaskTodo(name));
        return Message.addTaskOk;
    }
}
