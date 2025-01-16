package facebook.facebook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FacebookService {
    private static FacebookService instance;
    private Map<String, User> users;
    private Map<String, Post> posts;

    private FacebookService(){
        users = new ConcurrentHashMap<>();
        posts = new ConcurrentHashMap<>();
    }

    public synchronized static FacebookService getInstance(){
        if(instance == null){
            instance = new FacebookService();
        }
        return instance;
    }

    public void registerUser(User user){
        users.put(user.getUserId(), user);
    }

    public User loginUser(String email, String password){
        for(User user: users.values()){
            if(user.getEmailId().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user){
        users.put(user.getUserId(), user);
    }

    public void sendFriendRequest(String senderId, String recieverId){
        User sender = users.get(senderId);
        User reciever = users.get(recieverId);

        if(reciever != null){
            Notification notification = new Notification(senderId, recieverId, new Timestamp(System.currentTimeMillis()), NotificationType.FRIEND_REQUEST, "You have a friend request");
            System.out.println("Friend request sent by: " + sender.getUserName() + ", to: " + reciever.getUserName());
            reciever.addNotifications(notification);
        }
    }

    public void acceptRequest(String recieverId, String senderId){
        User reciever = users.get(recieverId);
        User sender = users.get(senderId);
        List<Notification> notifications = reciever.getNotifications();
        for(Notification notification: notifications){
            if(notification.getSenderId().equals(senderId) && notification.getNotificationType().equals(NotificationType.FRIEND_REQUEST)){
                System.out.println("Friend Request accepted by: " + reciever.getUserName() + " sent from: " + sender.getUserName());
            }
        }
    }

    public void post(Post post){
        User user = users.get(post.getAuthorId());
        user.addPosts(post);
        posts.put(post.getPostId(), post);
    }

    public synchronized void likePost(String postId, String userId){
        Post post = posts.get(postId);
        if(post == null){
            System.out.println("No such post exists!");
            return;
        }
        post.addLike(userId);
    }

    public void commentOnPost(Comment comment){
        Post post = posts.get(comment.getPostId());
        if(post == null){
            System.out.println("No such post exists!");
            return;
        }
        post.addComment(comment.getAuthorId(), comment);
    }

    public List<Post> getNewsFeed(String userId){
        User user = users.get(userId);
        List<Post> newsFeed = new ArrayList<>();
        List<User> friends = user.getFriends();
        newsFeed.addAll(user.getPosts());
        for(User friend: friends){
            newsFeed.addAll(friend.getPosts());
        }
        return newsFeed;
    }

    public List<Notification> getNotifications(String userId){
        User user = users.get(userId);
        return user.getNotifications();
    }
}
