
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TodoListShould {

    TodoListApp todoListApp;
    Console console;

    @BeforeEach
    public void initTest(){
        todoListApp = new TodoListApp();
        console = mock(Console.class);
    }

    @Test
    public void show_a_addTaskOk_Message_When_a_New_Task_is_added_Correctly (){

        assertEquals(Message.addTaskOk,todoListApp.addTaskTodoList("First Task",1));
    }

    @Test
    public void show_a_InvalidNameTask_When_name_Task_has_not_only_Alphanumeric_and_space_character (){

        assertEquals(Message.invalidNameTask,todoListApp.addTaskTodoList("First ????",1));
    }

    @Test
    public void show_a_MarkAsCompleted_When_mark_a_task_as_completed(){
        todoListApp.addTaskTodoList("Completed Task",1);

        assertEquals(Message.markAsCompleted,todoListApp.completedTask(1));
    }

    @Test
    public void show_a_NotFoundTask_When_TaskID_not_exist(){
        todoListApp.addTaskTodoList("Completed Task",1);

        assertEquals(Message.taskNotFound,todoListApp.completedTask(2));
    }

    @Test
    public void show_a_list_of_All_task(){
        todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Show Task",1);
        todoListApp.completedTask(1);
        todoListApp.addTaskTodoList("Second Task",2);
        todoListApp.addTaskTodoList("Third Task",3);
        todoListApp.completedTask(3);
        todoListApp.addTaskTodoList("Fourth Task",4);

        todoListApp.showTodoList();

        String ExpectedToDoList = "id: 1\nTask: Show Task\nStatus: Completed\nDue: 20-04-2020\n";
        ExpectedToDoList += "id: 2\nTask: Second Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        ExpectedToDoList += "id: 3\nTask: Third Task\nStatus: Completed\nDue: 20-04-2020\n";
        ExpectedToDoList += "id: 4\nTask: Fourth Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }

    @Test
    public void show_a_list_of_only_Completed_Task(){
        todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Completed Task",1);
        todoListApp.completedTask(1);
        todoListApp.addTaskTodoList("Incomplete Task",2);

        todoListApp.showCompletedTask();

        String ExpectedToDoList = "id: 1\nTask: Completed Task\nStatus: Completed\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }

    @Test
    public void show_a_list_of_only_Incomplete_Task(){
        todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Completed Task",1);
        todoListApp.completedTask(1);
        todoListApp.addTaskTodoList("Incomplete Task",2);

        todoListApp.showIncompleteTask();

        String ExpectedToDoList = "id: 2\nTask: Incomplete Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        verify(console).printLine(ExpectedToDoList);
    }


    @Test
    public void show_a_addSubTaskOk_Message_When_a_New_SubTask_is_added_to_their_Father_Correctly (){
        todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Father Task",1);
        todoListApp.addSubtaskToTaskFather(1,10,"Daughter Task");

        assertEquals(Message.addSubTaskOk,todoListApp.addSubtaskToTaskFather(1,10,"Daughter Task"));
    }

    @Test
    public void show_a_list_of_task_with_the_subtask_of_each_one_if_not_have_Subtask_only_show_the_task (){
        todoListApp = new TodoListApp(console);

        todoListApp.addTaskTodoList("Father Task",1);
        todoListApp.addSubtaskToTaskFather(1, 10,"Daughter Task");
        todoListApp.addSubtaskToTaskFather(1, 11,"Second Daughter Task");
        todoListApp.addTaskTodoList("Single Task",2);
        todoListApp.addTaskTodoList("Third Task",3);
        todoListApp.completedTask(3);


        todoListApp.showTodoList();

        String ExpectedToDoList = "id: 1\nTask: Father Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        ExpectedToDoList += "> Child Task <";
        ExpectedToDoList += "id: 10\nTask: Daughter Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        ExpectedToDoList += "id: 11\nTask: Second Daughter Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        ExpectedToDoList += "> --- <";
        ExpectedToDoList += "id: 2\nTask: Single Task\nStatus: Incomplete\nDue: 20-04-2020\n";
        ExpectedToDoList += "id: 3\nTask: Third Task\nStatus: Completed\nDue: 20-04-2020\n";

        verify(console).printLine(ExpectedToDoList);
    }

}
