import java.util.ArrayList;
import java.util.List;

public class SubTaskList {

    private List<TaskTodo> listSubTask;


    public SubTaskList() {
        this.listSubTask = new ArrayList<TaskTodo>();
    }

    public Message addSubTask(TaskTodo taskTodo){
        listSubTask.add(taskTodo);
        return Message.addSubTaskOk;
    }

    public boolean isEmpty() {
        if(listSubTask.size() != 0 ){
            return false;
        }
        return true;
    }

    public boolean areAllCompleted() {

        if(listSubTask.isEmpty()){
            return true;
        }
        for (TaskTodo subTask: listSubTask) {
            if(!subTask.isTaskCompleted()){
                return false;
            }
        }
        return true;
    }

    public Message subTaskCompleted(int idDaughter) {
        for (TaskTodo subTask: listSubTask) {
            if(subTask.isIdEquals(idDaughter)){
                subTask.completedSubTask();
                return Message.markAsCompletedSubTask;
            }
        }
        return Message.subTaskNotFound;

    }

    @Override
    public String toString() {
        String subTaskString = "";
        for (TaskTodo subTask: listSubTask) {
            subTaskString +=  subTask.toString();
        }
        return subTaskString;
    }
}
