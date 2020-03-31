package SocialNetwork.Commands;

import SocialNetwork.User;

public class FollowCommand implements Command {

    User user;
    User friend;

    public FollowCommand(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    @Override
    public void executeCommand() {

        user.addFriend(friend);
    }
}
