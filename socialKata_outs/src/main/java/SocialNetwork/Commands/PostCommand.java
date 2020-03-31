package SocialNetwork.Commands;

import SocialNetwork.*;

public class PostCommand implements Command {

    User user;
    String postString;

    public PostCommand(User user, String postString) {
        this.user = user;
        this.postString = postString;
    }

    @Override
    public void executeCommand() {

        Post post = new Post(user,postString);
        user.addPostToWall(post);

    }

}
