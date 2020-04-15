package UnitTest;

import SocialNetwork.Commands.CommandParse;
import SocialNetwork.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DatePostTestShould {

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
    public void testDatePersonalplusFriendsWallMain() throws InterruptedException {

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);

        User alice = new User("Alice",console);
        User bob = new User("Bob",console);

        Post post1 = new Post(alice,"I love the weather today");
        Thread.sleep(2000);
        Post post2 = new Post(bob,"Second");
        Thread.sleep(2000);
        Post post3 = new Post(alice,"Third");
        Thread.sleep(2000);
        Post post4 = new Post(bob,"Fourth");
        Thread.sleep(2000);
        Post post5 = new Post(alice,"Fifth");

        alice.addPostToWall(post1);
        alice.addPostToWall(post3);
        alice.addPostToWall(post5);

        bob.addPostToWall(post2);
        bob.addPostToWall(post4);

        socialNetworkApp.main("Alice");

        verify(console).printline("Personal Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");
        verify(console).printline(" - Fifth");

    }


    @Test
    public void testDatePersonalWall() throws InterruptedException {

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);

        socialNetworkApp.main("Alice -> I love the weather today");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Second");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Third");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Fourth");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice");

        verify(console).printline("Personal Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Second");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");

    }

    @Test
    public void testDatePersonalplusFriendsWall() throws InterruptedException {

        SocialNetwork socialNetwork = new SocialNetwork();
        commandParse = new CommandParse(socialNetwork,console);
        SocialNetworkApp socialNetworkApp = new SocialNetworkApp(commandParse);

        socialNetworkApp.main("Alice -> I love the weather today");
        Thread.sleep(2000);
        socialNetworkApp.main("Bob -> Hate weather today");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Third");
        Thread.sleep(2000);
        socialNetworkApp.main("Bob -> Fourth");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice -> Five");
        Thread.sleep(2000);
        socialNetworkApp.main("Alice follows Bob");

        socialNetworkApp.main("Alice wall");

        verify(console).printline("Wall");
        verify(console).printline(" - I love the weather today");
        verify(console).printline(" - Hate weather today");
        verify(console).printline(" - Third");
        verify(console).printline(" - Fourth");
        verify(console).printline(" - Five");

    }



}
