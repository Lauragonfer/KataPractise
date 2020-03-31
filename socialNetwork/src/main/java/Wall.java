

import java.util.ArrayList;
import java.util.List;

public class Wall {

    private List<Post> postList = new ArrayList<>();

    public  void Wall(){
        this.postList = new ArrayList<Post>();
    }

    public  void Wall(List<Post> postListNueva){
        this.postList = postListNueva;
    }

    public void addPost(String postMessage, UserSocialNet user) {
        Post newPost = new Post(postMessage, user);
        postList.add(newPost);
    }

    public void showListPostOfTheWall(){
        System.out.println(Message.ONLY_USER_WALL.label);
        for (Post post: this.postList) {
            System.out.println(post.toString());
        }
    }

    public void showListPostOfOneWall(Wall showWall){
        System.out.println(Message.GENERAL_USER_WALL.label);
        for (Post post: showWall.postList) {
            System.out.println(post.toString());
        }
    }

    public Wall createGeneralWallWithFollowersPost(Wall wallFriends){
        Wall newWall = new Wall();
        newWall = addpostListToWall(this.postList,newWall);
        newWall.addExistingWall(wallFriends);
        return newWall;

    }

    public Wall addpostListToWall(List<Post> newPostList, Wall newWall) {
        newWall.add_post_List_To_List_of_post(newPostList);
        return newWall;
    }

    private void add_post_List_To_List_of_post(List<Post> newPostList) {
        postList.addAll(newPostList);
    }

    public void addExistingWall(Wall userWall) {
        this.postList.addAll(userWall.postList);
    }
}
