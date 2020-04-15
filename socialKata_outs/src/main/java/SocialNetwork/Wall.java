package SocialNetwork;

import java.util.*;

public class Wall {

    List<Post> postList;
    Console console;

    static final String HEADPERSONALWALL = "Personal Wall";
    static final String HEADWALL = "Wall";


    public Wall(Console console) {
        this.postList = new ArrayList<Post>();
        this.console = console;
    }


    public void addPostWall(Post post) {
        postList.add(post);
    }

    public void showPersonalWall(){

        console.printline(HEADPERSONALWALL);

        if (!postList.isEmpty())
        {
            for (Post postWall: postList) {
                //console.printline(" -"+postWall.postMessage);
                System.out.println(postWall.printPost());
                console.printline(postWall.printPost());
            }
        }

    }

    public void showPostList(List<Post> listPost){

        console.printline(HEADWALL);

        if (!listPost.isEmpty())
        {
            for (Post postWall: listPost) {
                console.printline(postWall.printPost());
                console.printline(" -"+postWall.postMessage);
            }
        }

    }



    public void showPersonalAndFriendsWAll(List<Wall> friendsList) {

        List<Post> friendsAndUserPostList = new ArrayList<Post>();

        friendsAndUserPostList.addAll(postList);

        for (Wall wallFriend : friendsList){
           friendsAndUserPostList.addAll(wallFriend.postList);
        }


        showPostList(orderWallPostByDate(friendsAndUserPostList));
    }

    private List<Post> orderWallPostByDate(List<Post> postListAll) {

      /*  Collections.sort(postListAll, new Comparator() {

            @Override
            public int compare(.Post post1, Post post2) {
                return new Date(post1.getDate()).compareTo(new Date(post2.datePost)));
            }
        });*/
      return postListAll;

    }
}
