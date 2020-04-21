import java.util.HashMap;
import java.util.Map;

public class SubTaskList {

    private Map<TaskId, TaskTodo> mapSubTask;

    public SubTaskList() {
        this.mapSubTask = new HashMap<>();
    }

    public Message addSubTask(TaskId idTask,TaskTodo taskTodo){
        mapSubTask.put(idTask,taskTodo);
        return Message.addSubTaskOk;
    }

    public boolean areAllCompleted() {
        if(mapSubTask.isEmpty()){
            return true;
        }
        for (TaskTodo subTask : mapSubTask.values()) {
            if(!subTask.isTaskCompleted()){
                return false;
            }
        }
        return true;
    }

    public Message subTaskCompleted(int idDaughter) {
        TaskId idSubtask = new TaskId(idDaughter);
        if (mapSubTask.containsKey(idSubtask)){
            TaskTodo subtask = mapSubTask.get(idSubtask);
            subtask.completedSubTask();
            return Message.markAsCompletedSubTask;
        }
        return Message.subTaskNotFound;
    }

    @Override
    public String toString() {
        String subTaskString = "";
        for (TaskTodo subTask : mapSubTask.values()) {
            subTaskString +=  subTask.toString();
        }
        return subTaskString;
    }

    public boolean isEmptySubtaskMap() {
        if(mapSubTask.isEmpty()){
            return true;
        }
        return false;
    }
}
