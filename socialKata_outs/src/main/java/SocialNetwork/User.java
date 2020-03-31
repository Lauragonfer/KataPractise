package SocialNetwork;

import java.util.List;

public class User {

    Wall wall;
    String name;
    Friends friends;

    public User(String name,Console console) {
        this.name = name;
        this.wall = new Wall(console);
        this.friends = new Friends(console);
    }

    public void addPostToWall(Post post) {
        wall.addPostWall(post);
    }

    public void showPersonalWall() {
        wall.showPersonalWall();
    }

    public void addFriend(User friend) {
        friends.addFriend(friend);
    }

    public void showFriends(){
        friends.showFriends();
    }

    public void showFriendsWall() {
        List<Wall> friendsWalls =  friends.retrieveFriendsWalls();
        wall.showPersonalAndFriendsWAll(friendsWalls);
    }
}
