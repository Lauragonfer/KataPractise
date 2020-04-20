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
        if(checkIfTaskNameIsValid(name)){

            return todoList.addTask(name,id);
        }
        return  Message.invalidNameTask;
    }

    public Message addSubtaskToTaskFather(int idFather, int idDaugther, String name) {
        if(checkIfTaskNameIsValid(name)){

            return todoList.addSubTask(idFather,idDaugther,name);
        }
        return  Message.invalidNameTask;
    }

    private boolean checkIfTaskNameIsValid(String name) {
        if(name.matches("[a-zA-Z0-9 ]+") && (name.length() >= 5 && name.length() <=20))
        {
            return true;
        }
        return false;
    }

    public Message completedTask(int id) {
        return todoList.markTaskAsCompleted (id);
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
