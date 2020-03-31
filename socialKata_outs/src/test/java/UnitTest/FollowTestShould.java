package UnitTest;

import SocialNetwork.*;

import SocialNetwork.Commands.CommandParse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class FollowTestShould {

    Console console;
    CommandParse commandParse;



    @BeforeEach
    public void TestInit(){
        console = mock(Console.class);

    }

    @Test
    public void show_list_of_user_friends_and_add_a_New_Friend_with_command_FOLLOW(){

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
        User user1 = new User("Alice",console);
        User user2 = new User("Bob",console);

        socialNetwork.addUser(user1);
        socialNetwork.addUser(user2);

        socialNetworkApp.main("Alice follows Bob");
        user1.showFriends();

        verify(console).printline("Friends List");
        verify(console).printline(" - Bob");
    }


    @Test
    public void show_User_Wall_plus_All_Your_friends_wall_with_command_WALL(){

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);

        socialNetworkApp.main("Alice -> I love the weather today");
        socialNetworkApp.main("Alice -> Second");
        socialNetworkApp.main("Alice -> Third");
        socialNetworkApp.main("Alice -> Fourth");

        socialNetworkApp.main("Bob -> Post things");
        socialNetworkApp.main("Bob -> one thing");
        socialNetworkApp.main("Bob -> two thing");
        socialNetworkApp.main("Bob -> three thing");

        socialNetworkApp.main("Alice follows Bob");
        socialNetworkApp.main("Alice wall");

        verify(console).printline("Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");
        verify(console).printline(" - Post things");
        verify(console).printline(" - one thing");
        verify(console).printline(" - two thing");
        verify(console).printline(" - three thing");

    }



}
