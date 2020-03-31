package SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class Friends {

    List<User> friendsList;
    Console console;

    public Friends(Console console) {
        this.friendsList = new ArrayList<User>();
        this.console = console;
    }

    public void addFriend(User user){
        friendsList.add(user);
    }

    public void showFriends(){

        console.printline("Friends List");

        if (!friendsList.isEmpty())
        {
            for (User user: friendsList) {
                console.printline(" - "+user.name);
            }
        }
    }

    public List<Wall> retrieveFriendsWalls() {

        List <Wall> friendsWalls = new ArrayList<Wall>();

        if (!friendsList.isEmpty())
        {
            for (User user: friendsList) {
                friendsWalls.add(user.wall);
            }
        }
        return friendsWalls;
    }
}
