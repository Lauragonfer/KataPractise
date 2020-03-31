package SocialNetwork.Commands;

import SocialNetwork.*;

public class CommandParse {

    static final String ADDPOSTWALL = "->";
    static final String FOLLOW = "follows";
    static final String WALL = "wall";

    SocialNetwork socialNetwork;
    Console console;

    Command command;


    public CommandParse(SocialNetwork socialNetwork, Console console) {
        this.socialNetwork = socialNetwork;
        this.console = console;
    }

    public void processOrder(String order) {

        User user;

        if (!containsCommandOrder(order)){

            user = userOfTheInput(order);
            command = new ReadWallCommand(user);
        }

        if(order.contains(ADDPOSTWALL) ){

            command = new PostCommand (parseInputShowUserAddPost(order),parseInputPostMessage(order));
        }

        if(order.contains(FOLLOW) ){

            command = new FollowCommand (parseInputShowUserFollow(order),parseInputFollowOtherUser(order));
        }

        if(order.contains(WALL) ){

            command = new WallCommand (parseInputShowUserWall(order));
        }

        command.executeCommand();

    }

    private User parseInputFollowOtherUser(String order) {
        String friendName = order.substring(order.indexOf(FOLLOW)+7);
        return socialNetwork.retrieveUserInSocialNetwork(friendName.trim());
    }

    private User parseInputShowUserFollow(String order) {
        String userName = order.substring(0,order.indexOf(FOLLOW));
        return socialNetwork.retrieveUserInSocialNetwork(userName.trim());

    }

    private User parseInputShowUserWall(String order) {
        String userName = order.substring(0,order.indexOf(WALL));
        return socialNetwork.retrieveUserInSocialNetwork(userName.trim());

    }

    private User userOfTheInput(String order) {

        User user;

        if(!socialNetwork.checkIfUserExist(order)){
            user = new User(order,console);
            socialNetwork.addUser(user);
            return user;
        }
         return  socialNetwork.retrieveUserInSocialNetwork(order);
    }


    private String parseInputPostMessage(String order) {
        return order.substring(order.indexOf(">")+1);
    }

    private User parseInputShowUserAddPost(String order) {
        String userName = order.substring(0,order.indexOf("-"));

        return userOfTheInput(userName.trim());
    }

    private boolean containsCommandOrder(String order) {
        if (order.contains(WALL) || order.contains(ADDPOSTWALL) || order.contains(FOLLOW)){
            return true;
        }
        return false;
    }



}
