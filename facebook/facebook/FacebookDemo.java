package facebook.facebook;

import java.sql.Timestamp;
import java.util.List;


public class FacebookDemo {
    public static void run(){
        FacebookService facebookService = FacebookService.getInstance();

        //Create user
        User user1 = new User("John Doe", "john@gmail.com", "password1", "John", "profile_pic_1.png");
        User user2 = new User("Sam Altman", "sam@gmail.com", "password2", "Sam", "profile_pic_2.png");

        facebookService.registerUser(user1);
        facebookService.registerUser(user2);

        User loggedInUser = facebookService.loginUser("john@gmail.com", "password1");
        if(loggedInUser != null){
            System.out.println("User logged in successfully!");
        }else{
            System.out.println("Invalid credentials!");
        }

        loggedInUser.setUserName("New John");
        loggedInUser.setProfilePic("new_profile_pic_1");
        facebookService.updateUser(loggedInUser);

        facebookService.sendFriendRequest(user1.getUserId(), user2.getUserId());

        facebookService.acceptRequest(user2.getUserId(), user1.getUserId());

        Post post1 = new Post("Post 1", user1.getUserId(), "This is a new post by user 1.", new Timestamp(System.currentTimeMillis()));
        Post post2 = new Post("Post 2", user2.getUserId(), "This is a new post by user 2.", new Timestamp(System.currentTimeMillis()));
        facebookService.post(post1);
        facebookService.post(post2);

        facebookService.likePost(post1.getPostId(), user2.getUserId());

        Comment comment = new Comment("Comment 1", user2.getUserId(), post1.getPostId(), "This is a new comment", new Timestamp(System.currentTimeMillis()));
        facebookService.commentOnPost(comment);

        List<Post> newsFeed = facebookService.getNewsFeed(user1.getUserId());
        for(Post post: newsFeed){
            System.out.println("Post: " + post.getContent());
            System.out.println("Likes: " + post.getLikes().size());
            System.out.println("Comments: " + post.getComments().size());
            System.out.println();
        }

        List<Notification> notifs = facebookService.getNotifications(user1.getUserId());
        for(Notification notification: notifs){
            System.out.println("Notfication type"+ notification.getNotificationType().toString());
            System.out.println("Notfication content"+ notification.getContent());
            System.out.println();
        }


    }
    public static void main(String[] args) {
        run();
    }
}
