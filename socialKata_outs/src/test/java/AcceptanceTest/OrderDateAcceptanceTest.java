package AcceptanceTest;

import SocialNetwork.Commands.CommandParse;
import SocialNetwork.Console;
import SocialNetwork.SocialNetwork;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import SocialNetwork.*;

public class OrderDateAcceptanceTest {

    @Test
    public void OrderDateAcceptanceTest() throws InterruptedException {

        Console console = mock(Console.class);
        SocialNetwork socialNetwork = new SocialNetwork();
        CommandParse commandParse = new CommandParse(socialNetwork,console);

        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);
        socialNetworkApp.main("Alice -> I love the weather today");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Second");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Third");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Fourth");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice wall");

        verify(console).printline("Personal Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");

    }
}
