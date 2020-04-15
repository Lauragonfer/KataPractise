package UnitTest;

import SocialNetwork.*;

import SocialNetwork.Commands.Command;
import SocialNetwork.Commands.CommandParse;
import SocialNetwork.Commands.PostCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PostReadTestShould {

    Console console;
    SocialNetwork socialNetworkMock;
    CommandParse commandParse;
    User userMock;
    Wall wallMock;

    @BeforeEach
    public void TestInit(){
        console = mock(Console.class);
        socialNetworkMock = mock(SocialNetwork.class);
        userMock = mock(User.class);
        wallMock = mock(Wall.class);


    }

    @Test
    public void check_process_command_post(){

        Command commandPost = new PostCommand(userMock," I love the weather today");

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);

        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
        socialNetworkApp.main("Alice -> I love the weather today");

        Post post = new Post(userMock, " I love the weather today");
        verify(userMock).addPostToWall(post);

    }

    @Test
    public void check_if_user_exist_and_show_the_personal_wall_with_READCOMMAND(){

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
        socialNetworkApp.main("Alice");

        verify(console).printline("Personal Wall");
    }

   @Test
    public void check_if_user_make_a_post_and_check_the_personal_wall_with_POSTCOMMAND(){
       SocialNetwork socialNetwork = new SocialNetwork();
       commandParse = new CommandParse(socialNetwork,console);
       SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
       socialNetworkApp.main("Alice -> I love the weather today");
       socialNetworkApp.main("Alice");

       Post post = new Post(userMock, " I love the weather today");

       verify(console).printline("Personal Wall");
       verify(console).printline(" -"+post.postMessage);

    }

    @Test
    public void check_if_user_exist_make_a_bunch_of_post_and_show_the_personal_wall(){
        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);

        socialNetworkApp.main("Alice -> I love the weather today");
        socialNetworkApp.main("Alice -> Second");
        socialNetworkApp.main("Alice -> Third");
        socialNetworkApp.main("Alice -> Fourth");
        socialNetworkApp.main("Alice");

        verify(console).printline("Personal Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");

    }



}
