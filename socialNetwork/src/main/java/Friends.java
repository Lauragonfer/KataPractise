import java.util.ArrayList;
import java.util.List;

public class Friends {

    private List<UserSocialNet> followList = new ArrayList<>() ;

    public  void Friends(){
        this.followList = new ArrayList<UserSocialNet>();
    }

    public  void Friends(List<UserSocialNet> followList){
        this.followList = followList;
    }

    public Message addFriends (UserSocialNet userFriend){

        if (!checkIfYouFollowTheUser(userFriend)){

            followList.add(userFriend);
            System.out.println(Message.FOLLOWING.label);
            return Message.FOLLOWING;
        }
        System.out.println(Message.ALREADY_FOLLOWING.label);
        return Message.ALREADY_FOLLOWING;
    }

    public boolean checkIfYouFollowTheUser(UserSocialNet friend){
        for (UserSocialNet alreadyFriend: this.followList) {
            if (alreadyFriend.equals(friend.getUserName())){
                return  true;
            }
        }
        return false;
    }

    public Wall get_list_post_Follow_Friends(){
        Wall wallFriends = new Wall();
        for (UserSocialNet friend : followList ) {
            wallFriends.addExistingWall(friend.getUserWall());
        }
        return wallFriends;
    }

    public void showFollwingUsers (){
        System.out.println(Message.USER_FRIEND_LIST.label);
        for (UserSocialNet userFollow : this.followList) {
            System.out.println(userFollow.getUserName());
        }
    }

    public boolean checkIfistEmpty() {
        return followList.isEmpty();
    }
}
