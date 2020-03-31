package SocialNetwork;

import SocialNetwork.Commands.CommandParse;

public class SocialNetworkApp {

    CommandParse commandParse;

    public SocialNetworkApp(CommandParse commandParse) {
        this.commandParse = commandParse;
    }

    public void main(String order){
        commandParse.processOrder(order);
    }

}
