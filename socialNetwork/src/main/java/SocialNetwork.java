import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

   private List<UserSocialNet> userSocialNetList ;

    public SocialNetwork (List<UserSocialNet> userSocialNetList){this.userSocialNetList = userSocialNetList; }

    public SocialNetwork() {this.userSocialNetList = new ArrayList<UserSocialNet>();}


    public boolean checkIfUserExistInThisSocialNetwork(String userName){
        for (UserSocialNet user: this.userSocialNetList) {
                if(user.equals(userName)) {
                    return true;
                }
            }
        return false;
    }

    public boolean check_if_socialNetwork_is_empty(){
        if(userSocialNetList.isEmpty())
        {
           return true;
        }
        return false;
    }



    public UserSocialNet retrieveUserInSocialNetwork (String userName){
         for (UserSocialNet userCompare: this.userSocialNetList) {
                if(userCompare.equals(userName)){
                   return userCompare;
                }
            }
            return null;
    }


    public boolean addNewUserToSocialNetwork(String newUserName) {
        if(!checkIfUserExistInThisSocialNetwork(newUserName)){
            UserSocialNet userNew = new UserSocialNet(newUserName);
            this.userSocialNetList.add(userNew);
            return true;
        }
        return false;
    }

    public void showNetworkUserList( ){
        System.out.println(Message.SOCIAL_NETWORK_USERS.label);
        for (UserSocialNet user: this.userSocialNetList) {
            System.out.println("Nombre: "+user.getUserName());

        }
    }
}
