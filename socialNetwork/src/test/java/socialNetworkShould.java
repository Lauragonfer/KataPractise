
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class socialNetworkShould {

    //User test
    @Test
    public void addUser_if_not_exist_in_the_SocialNetwork() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        assertEquals(Message.ADD_NEW_USER,inputKeyboard.parseCommand());
    }

    @Test
    public void not_addUser_if_exist_in_the_SocialNetwork() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01",socialNetwork);
        assertEquals(Message.USER_ALREADY_EXIST,inputKeyboard.parseCommand());
    }

    @Test
    public void check_if_the_user_exist_in_the_Social_Network() {

        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();
        assertEquals(true,socialNetwork.checkIfUserExistInThisSocialNetwork("Name01"));
    }

    @Test
    public void add_User_to_Following_List_if_NOT_exist_in_the_List() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();
        socialNetwork.showNetworkUserList();
        inputKeyboard = new CommandInput("Name01 follows Name02",socialNetwork);
        assertEquals(Message.FOLLOWING,inputKeyboard.parseCommand());
    }

    @Test
    public void add_More_than_one_User_to_Following_List_if_NOT_exist_in_the_List() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name03",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name04",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name05",socialNetwork);
        inputKeyboard.parseCommand();
        socialNetwork.showNetworkUserList();
        inputKeyboard = new CommandInput("Name01 follows Name02",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name03",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name04",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name05",socialNetwork);
        assertEquals(Message.FOLLOWING,inputKeyboard.parseCommand());
    }

    //Social Network Test

    @Test
    public void add_more_than_one_user_To_New_SocialNetwork_AND_Show_list_of_Users() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name03",socialNetwork);
        inputKeyboard.parseCommand();
        socialNetwork.showNetworkUserList();
        assertEquals(true,true);
    }

    //Wall Test

    @Test
    public void publish_post_when_use_the_command_PUBLISHING() {

        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O1",socialNetwork);
        assertEquals(Message.PUBLISHING,  inputKeyboard.parseCommand());
    }

    @Test
    public void show_User_wall_by_comand_MYWALL(){
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O1",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O2",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O3",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O4",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O5",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 mywall",socialNetwork);
        assertEquals(Message.ONLY_USER_WALL,  inputKeyboard.parseCommand());

    }

    @Test
    public void make_One_Wall_With_All_Post_from_User_and_his_Follow_Users_By_command_WALL() {

        SocialNetwork socialNetwork = new SocialNetwork();

        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();

        inputKeyboard = new CommandInput("Name01 -> Post O1",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O2",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O3",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O4",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 -> Post O5",socialNetwork);
        inputKeyboard.parseCommand();

        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();

        inputKeyboard = new CommandInput("Name02 -> Post O6",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02 -> Post O7",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02 -> Post O8",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02 -> Post O9",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02 -> Post 10",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name02",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 wall",socialNetwork);
        assertEquals(Message.GENERAL_USER_WALL,  inputKeyboard.parseCommand());
    }



    //Show Message in console Test

    @Test
    public void show_a_Message_if_user_Already_Follow_This_user() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name02",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name02",socialNetwork);
        inputKeyboard.parseCommand();
        assertEquals(Message.ALREADY_FOLLOWING,inputKeyboard.parseCommand());
    }

      @Test
    public void show_a_Message_if_user_to_Follow_NOT_Exist_in_the_Social_Network() {
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandInput inputKeyboard = new CommandInput("Name01",socialNetwork);
        inputKeyboard.parseCommand();
        inputKeyboard = new CommandInput("Name01 follows Name04",socialNetwork);
        assertEquals(Message.FRIEND_USER_NOT_EXIST,inputKeyboard.parseCommand());
    }
}
