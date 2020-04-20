public class TodoListApp {

    private TodoList todoList;
    Console console;


    public TodoListApp() {
        this.todoList = new TodoList();
    }
    public TodoListApp(Console console) {
        this.todoList = new TodoList();
        this.console = console;
    }

    public Message addTaskTodoList(String name, int id){
        return todoList.addTask(name,id);
    }

    public Message addSubtaskToTaskFather(int idFather, int idDaugther, String name) {
        return todoList.addSubTask(idFather,idDaugther,name);
    }

    public Message completedTask(int id) {
        return todoList.markTaskAsCompleted (id);
    }

    public Message completedSubTask(int idFather, int idDaughter) {
        return todoList.markSubTaskAsCompleted(idFather,idDaughter);
    }

    public void showTodoList() {
        console.printLine(todoList.printToDoList());
    }

    public void showCompletedTask() {
        console.printLine(todoList.printCompletedtask());
    }

    public void showIncompleteTask() {
        console.printLine(todoList.printIncompleteTask());
    }



}
