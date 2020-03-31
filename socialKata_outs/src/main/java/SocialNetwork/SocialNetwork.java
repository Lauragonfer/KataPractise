package SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    List <User> usersSocialNetwork;

    public SocialNetwork() {
        usersSocialNetwork = new ArrayList<User>();
    }

    public void addUser(User user) {
        usersSocialNetwork.add(user);
    }

    public boolean checkIfUserExist(String name) {

        for (User user : usersSocialNetwork) {
            if(user.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public User retrieveUserInSocialNetwork(String name) {

        for (User user : usersSocialNetwork) {
            if(user.name.equals(name)){
                return user;
            }
        }
        return null;
    }
}