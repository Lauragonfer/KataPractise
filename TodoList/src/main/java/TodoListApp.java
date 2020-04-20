public class TodoListApp {

    private TodoList todoList;


    public TodoListApp() {
        this.todoList = new TodoList();
    }

    public Message addTaskTodoList(String name){
        if(checkIfTaskNameIsValid(name)){
            return todoList.addTask(name);
        }
        return  Message.invalidNameTask;
    }

    private boolean checkIfTaskNameIsValid(String name) {
        return true;
    }

}
