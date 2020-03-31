package AcceptanceTest;

import SocialNetwork.*;

import SocialNetwork.Commands.CommandParse;
import org.junit.jupiter.api.Test;



import static org.mockito.Mockito.*;


public class PostAcceptanceTest {




    @Test
    public void PostAcceptanceTest(){

        Console console = mock(Console.class);
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandParse commandParse = new CommandParse(socialNetwork,console);

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
