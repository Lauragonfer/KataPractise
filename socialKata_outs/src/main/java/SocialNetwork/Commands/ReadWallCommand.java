package SocialNetwork.Commands;

import SocialNetwork.User;

public class ReadWallCommand implements Command {

    User user;


    public ReadWallCommand(User user) {
        this.user = user;
    }

    @Override
    public void executeCommand() {
        user.showPersonalWall();
    }


}
