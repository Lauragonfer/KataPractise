import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoListShould {

    @Test
    public void show_a_addTaskOk_Message_When_a_New_Task_is_added_Correctly (){
        TodoListApp todoListApp = new TodoListApp();
        assertEquals(Message.addTaskOk,todoListApp.addTaskTodoList("First Task"));
    }


}
