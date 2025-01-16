package facebook.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private final String userId;
    private String fullName;
    private String emailId;
    private String password;
    private String userName;
    private String profilePic;
    private List<Notification> notifications;
    private List<Post> posts;
    private List<User> friends;

    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void addNotifications(Notification notification) {
        this.notifications.add(notification);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post post) {
        this.posts.add(post);
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void addFriends(User friend) {
        this.friends.add(friend);
    }

    public User(String fullName, String emailId, String password, String userName, String profilePic) {
        this.userId = generateUserId();
        this.fullName = fullName;
        this.emailId = emailId;
        this.password = password;
        this.userName = userName;
        this.profilePic = profilePic;
        this.notifications = new CopyOnWriteArrayList<>();
        this.posts = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    private String generateUserId(){
        return "USR_" + UUID.randomUUID();
    }
}
