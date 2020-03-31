public class CommandInput {

     public static final String MYWALL = "mywall";
     public static final String ADDPOSTWALL = "->";
     public static final String FOLLOW = "follows";
     public static final String WALL = "wall";

     String parseInput;

    SocialNetwork socialNetwork;

    public CommandInput(String parseInput, SocialNetwork socialNetwork) {
        this.parseInput = parseInput;
        this.socialNetwork = socialNetwork;
    }


    public Message  parseCommand (){

         if (containsCommandOrder()){
             if(parseInput.contains(MYWALL)){
                 Commando commando = new Commando( parseInputUsersShowWall());
                 return commando.showUserWall();
             }
             if(parseInput.contains(WALL)){
                 Commando commando = new Commando(parseInputShowUserGeneralWall());
                 return commando.showUserWallGeneral();
             }
             if(parseInput.contains(ADDPOSTWALL)){
                 Commando commando = new Commando( parseInputShowUserAddPost(),  parseInputPostMessage(),socialNetwork);
                 return commando.postMessage();
             }
             if(parseInput.contains(FOLLOW)){
                 Commando commando = new Commando(parseInputShowUserFollows(), parseInputShowFriendFollows(),socialNetwork);
                 return  commando.followUser();
             }
         }
         if (!containsCommandOrder()){
             Commando commando = new Commando(parseInput,socialNetwork);
             return commando.addNewUser();
         }
         return Message.WRONG_COMMAND;
     }

    private UserSocialNet parseInputShowUserGeneralWall() {
        String userName = parseInput.substring(0,parseInput.indexOf(WALL));
        return socialNetwork.retrieveUserInSocialNetwork(userName.trim());
    }

    private  UserSocialNet parseInputUsersShowWall(){
         String userName = parseInput.substring(0,parseInput.indexOf(MYWALL));
         socialNetwork.showNetworkUserList();
         if(!socialNetwork.checkIfUserExistInThisSocialNetwork(userName.trim())){
             socialNetwork.addNewUserToSocialNetwork(userName.trim());
         }
         return socialNetwork.retrieveUserInSocialNetwork(userName.trim());
     }

    private UserSocialNet parseInputShowUserFollows() {
        String userName = parseInput.substring(0,parseInput.indexOf(FOLLOW));
        return socialNetwork.retrieveUserInSocialNetwork(userName.trim());
    }

    private String parseInputShowFriendFollows() {
        String friendName = parseInput.substring(parseInput.indexOf(FOLLOW)+7);
        return friendName.trim();
    }

    private String parseInputPostMessage() {
        return parseInput.substring(parseInput.indexOf(">"));
    }

    private UserSocialNet parseInputShowUserAddPost() {
        String userName = parseInput.substring(0,parseInput.indexOf("-"));
        return socialNetwork.retrieveUserInSocialNetwork(userName.trim());
    }

    private boolean containsCommandOrder() {
        if (this.parseInput.contains(MYWALL) || this.parseInput.contains(WALL) || this.parseInput.contains(ADDPOSTWALL) || this.parseInput.contains(FOLLOW)){
            return true;
        }
        return false;
    }







}
