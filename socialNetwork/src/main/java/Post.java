import java.util.Date;

public class Post {
    private String postMessage;
    private Date postDate;
    private UserSocialNet postUser;



    public Post(String postMessage, UserSocialNet user) {
        this.postMessage = postMessage;
        this.postUser = user;
        this.postDate = new Date();
    }

    @Override
    public String toString() {
        return postUser.getUserName()+" - "+postMessage+" - "+postDate;
    }
}
