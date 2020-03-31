package AcceptanceTest;

import SocialNetwork.*;
import SocialNetwork.Commands.CommandParse;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class FollowsAcceptanceTest {

    @Test
    public void FollowAcceptanceTest() {

        Console console = mock(Console.class);
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandParse commandParse = new CommandParse(socialNetwork, console);
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
