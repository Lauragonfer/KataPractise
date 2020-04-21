import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {

    private List<TaskTodo> todoListTasks;

    public TodoList() {
        this.todoListTasks = new ArrayList<TaskTodo>();
    }


    public Message addTask(String name,int id) {
        todoListTasks.add(new TaskTodo(name,id));
        return Message.addTaskOk;
    }

    public Message addSubTask(int idFather, int idDaugther, String name) {
        TaskTodo taskFather = retrieveTaskByID(idFather);

        if (taskFather != null){
            taskFather.addDaugther(idDaugther,name);
            return Message.addSubTaskOk;
        }
        return  Message.taskNotFound;
    }


    public Message markTaskAsCompleted(int id) {
        TaskTodo task = retrieveTaskByID(id);

        if(task == null)
        {
            return Message.taskNotFound;
        }
        return task.completedFatherTask();
    }

    public Message markSubTaskAsCompleted(int idFather, int idDaughter) {

        TaskTodo fatherTask = retrieveTaskByID(idFather);

        if(fatherTask == null)
        {
            return Message.fatherTaskNotFound;
        }
        return fatherTask.markSubTaskAsComplete(idDaughter);

    }

    public TaskTodo retrieveTaskByID(int id) {

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
            formatTaskList += task.toString();
            if(task.hasSubtask()){
                formatTaskList += "> Child Task <";
                formatTaskList += task.addPrintSubTask();
                formatTaskList += "> --- <";
            }
        }
        return formatTaskList;
    }

    public String printCompletedtask() {
        String formatTaskList= "";

        List<TaskTodo> lista = todoListTasks.stream().filter(taskTodo -> taskTodo.isTaskCompleted())
                .collect(Collectors.toList());

        for (TaskTodo task: lista) {
            formatTaskList += task.toString();
        }
        return formatTaskList;
    }

    public String printIncompleteTask() {
        String formatTaskList= "";
        for (TaskTodo task: todoListTasks) {
            if (!task.isTaskCompleted()){
                formatTaskList += task.toString();
            }
        }
        return formatTaskList;
    }



}
