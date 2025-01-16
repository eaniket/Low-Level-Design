package facebook.facebook;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Post {
    private final String postId;
    private final String postTitle;
    private final String authorId;
    private String content;
    private final Timestamp timestamp;
    private Set<String> likes;
    private List<Comment> comments;

    public String getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String updateContent(String newContent){
        this.content = newContent;
        return this.content;
    }

    public synchronized void addLike(String userId){
        likes.add(userId);
    }

    public Set<String> getLikes(){
        return this.likes;
    } 

    public synchronized void addComment(String userId, Comment comment){
        comments.add(comment);
    }

    public List<Comment> getComments(){
        return this.comments;
    } 

    public Post(String postTitle, String authorId, String content, Timestamp timestamp) {
        this.postId = generateId();
        this.postTitle = postTitle;
        this.authorId = authorId;
        this.content = content;
        this.timestamp = timestamp;
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    private String generateId(){
        return "POST_"+UUID.randomUUID();
    }
}
