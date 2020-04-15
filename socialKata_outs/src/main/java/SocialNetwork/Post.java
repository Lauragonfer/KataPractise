package SocialNetwork;

import java.util.Date;

public class Post {

    User user;
    public String postMessage;
    Date datePost;

    public Post(User user, String postString) {
        this.user = user;
        this.postMessage = postString;
        datePost = new Date();
    }

    public String printPost (){

        return  " - "+postMessage+" - "+datePost.toString();

    }


    public Date getDate() {
        return  datePost;
    }
}
