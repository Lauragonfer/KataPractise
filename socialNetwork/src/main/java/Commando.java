public class Commando {

   String commandInputData;
   UserSocialNet userCommand;
   SocialNetwork socialNetwork;
   String newUser;

    public Commando(UserSocialNet userCommand) {
        this.userCommand = userCommand;
    }

    public Commando(String newUser, SocialNetwork socialNetwork) {
        this.newUser = newUser;
        this.socialNetwork = socialNetwork;
    }

    public Commando(UserSocialNet user, String userToFollowName, SocialNetwork socialNetworkThisUser) {
        this.userCommand = user;
        this.commandInputData = userToFollowName;
        this.socialNetwork = socialNetworkThisUser;
    }

    public Message addNewUser() {
        if(socialNetwork.addNewUserToSocialNetwork(this.newUser)){
        return Message.ADD_NEW_USER;
        }
        return Message.USER_ALREADY_EXIST;
    }

    public Message postMessage() {
        System.out.println("Usuario"+userCommand);
        return userCommand.addPostWall(commandInputData);
    }

    public Message followUser() {
       if(socialNetwork.checkIfUserExistInThisSocialNetwork(commandInputData)){

            return userCommand.followUser(socialNetwork.retrieveUserInSocialNetwork(commandInputData));
       }
        return Message.FRIEND_USER_NOT_EXIST;

    }

    public Message showUserWall() {
        return userCommand.showUserWall();
    }

    public Message showUserWallGeneral() {
        return userCommand.showGeneralUserWall();
    }
}
