import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserSocialNet {

   // int idUser;
    private String userName;
    private Wall userWall ;
    private Friends friendsList;

    public UserSocialNet(){
        this.userName = "vacio";
        this.userWall = new Wall();
        this.friendsList = new Friends();
    }

    public UserSocialNet(String name) {

        this.userName = name;
        this.userWall = new Wall();
        this.friendsList = new Friends();
    }

    public Message followUser (UserSocialNet friend){
        return friendsList.addFriends(friend);
    }

    public Message addPostWall(String postMessage) {
       userWall.addPost(postMessage,this);
       System.out.println(Message.PUBLISHING.label);
       showUserWall();
       return Message.PUBLISHING;
    }

    public boolean compare_User_if_are_the_same(UserSocialNet user1, UserSocialNet user2){
        if (user1.equals(user2.userName)){
            return true;
        }
        return false;
    }

    public Message  showUserWall(){
        this.userWall.showListPostOfTheWall();
        return Message.ONLY_USER_WALL;
    }

    public Message  showGeneralUserWall(){
       ;
        userWall.showListPostOfOneWall(userWall.createGeneralWallWithFollowersPost(friendsList.get_list_post_Follow_Friends()));
        return Message.GENERAL_USER_WALL;
    }

    public void showUserFriends(){
        this.friendsList.showFollwingUsers();
    }

    public String getUserName(){
        return this.userName;
    }

    public Wall getUserWall() {
        return this.userWall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSocialNet that = (UserSocialNet) o;
        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}

