import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TodoListShould {

    @Test
    public void show_a_addTaskOk_Message_When_a_New_Task_is_added_Correctly (){
        TodoListApp todoListApp = new TodoListApp();
        assertEquals(Message.addTaskOk,todoListApp.addTaskTodoList("First Task",1));
    }

    @Test
    public void show_a_InvalidNameTask_When_name_Task_has_not_only_Alphanumeric_and_space_character (){
        TodoListApp todoListApp = new TodoListApp();
        assertEquals(Message.invalidNameTask,todoListApp.addTaskTodoList("First ????",1));
    }

    @Test
    public void show_a_MarkAsCompleted_When_mark_a_task_as_completed(){
        TodoListApp todoListApp = new TodoListApp();
        todoListApp.addTaskTodoList("Completed Task",1);
        assertEquals(Message.markAsCompleted,todoListApp.completedTask(1));
    }

    @Test
    public void show_a_NotFoundTask_When_TaskID_not_exist(){
        TodoListApp todoListApp = new TodoListApp();
        todoListApp.addTaskTodoList("Completed Task",1);
        assertEquals(Message.taskNotFound,todoListApp.completedTask(2));
    }

    @Test
    public void show_a_list_of_All_task(){

        Console console = mock(Console.class);
        TodoListApp todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Show Task",1);
        todoListApp.showTodoList();

        String ExpectedToDoList = "id: 1\nTask: Show Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }

    @Test
    public void show_a_list_of_only_Completed_Task(){

        Console console = mock(Console.class);
        TodoListApp todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Completed Task",1);
        todoListApp.completedTask(1);
        todoListApp.addTaskTodoList("Incomplete Task",2);
        todoListApp.showCompletedTask();
        String ExpectedToDoList = "id: 1\nTask: Completed Task\nStatus: Completed\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }

    @Test
    public void show_a_list_of_only_Incomplete_Task(){

        Console console = mock(Console.class);
        TodoListApp todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Completed Task",1);
        todoListApp.completedTask(1);
        todoListApp.addTaskTodoList("Incomplete Task",2);
        todoListApp.showIncompleteTask();
        String ExpectedToDoList = "id: 2\nTask: Incomplete Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }


}
