public enum Message {

        PUBLISHING ("Comment publish in your Wall"),
        FOLLOWING ("You are now following"),
        ONLY_USER_WALL("User WALL "),
        GENERAL_USER_WALL("User and Following users Wall "),
        WRONG_COMMAND("WRONG COMMAND "),
        USER_FRIEND_LIST("List Of Friends"),
        SOCIAL_NETWORK_USERS("List of ALL Social Network Users"),
        ALREADY_FOLLOWING("You already followig "),
        ADD_NEW_USER ("New USER added"),
        USER_ALREADY_EXIST("User Already Exist"),
        FRIEND_USER_NOT_EXIST("You CAN'T follow a non existing user");


    public final String label;

        private Message(String label) {
            this.label = label;
        }

}
