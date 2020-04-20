public class TodoListApp {

    private TodoList todoList;


    public TodoListApp() {
        this.todoList = new TodoList();
    }

    public Message addTaskTodoList(String name, int id){
        if(checkIfTaskNameIsValid(name)){

            return todoList.addTask(name,id);
        }
        return  Message.invalidNameTask;
    }

    private boolean checkIfTaskNameIsValid(String name) {
        return name.matches("[a-zA-Z0-9 ]+");
    }

    public Message completedTask(int id) {
        return todoList.markTaskAsCompleted (id);
    }
}
