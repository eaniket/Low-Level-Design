package facebook.facebook;

import java.sql.Timestamp;
import java.util.UUID;

public class Comment {
    private final String commentId;
    private final String commentTitle;
    private final String authorId;
    private final String postId;
    private String content;
    private final Timestamp timestamp;

    public String getCommentId() {
        return commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public String updateContent(String newContent){
        this.content = newContent;
        return newContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Comment(String commentTitle, String authorId, String postId, String content, Timestamp timestamp) {
        this.commentId = generateId();
        this.commentTitle = commentTitle;
        this.authorId = authorId;
        this.postId = postId;
        this.content = content;
        this.timestamp = timestamp;
    }

    private String generateId(){
        return "POST_"+UUID.randomUUID();
    }
}
