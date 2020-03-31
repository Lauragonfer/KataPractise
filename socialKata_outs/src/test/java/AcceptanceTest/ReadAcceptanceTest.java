package AcceptanceTest;

import SocialNetwork.*;

import SocialNetwork.Commands.CommandParse;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ReadAcceptanceTest {

    @Test
    public void ReadAcceptanceTest(){

        Console console = mock(Console.class);
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandParse commandParse = new CommandParse(socialNetwork,console);

        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
        socialNetworkApp.main("Bob -> I love the weather today");
        socialNetworkApp.main("Bob -> Second");
        socialNetworkApp.main("Bob -> Third");
        socialNetworkApp.main("Bob -> Fourth");
        socialNetworkApp.main("Bob");

        verify(console).printline("Personal Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");

    }
}
