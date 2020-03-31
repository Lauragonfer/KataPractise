package SocialNetwork.Commands;

import SocialNetwork.User;

public class WallCommand implements Command {

    private final User user;

    public WallCommand(User user) {
        this.user = user;
    }

    @Override
    public void executeCommand() {
        user.showFriendsWall() ;
    }
}
