package SocialNetwork;

public class Post {

    User user;
    public String postMessage;

    public Post(User user, String postString) {
        this.user = user;
        this.postMessage = postString;
    }

}
