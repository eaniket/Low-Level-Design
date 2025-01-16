package facebook.facebook;

import java.sql.Timestamp;

public class Notification {
    private final String senderId;
    private final String receiverId;
    private final Timestamp timestamp;
    private final NotificationType notificationType;
    private final String content;
    public String getSenderId() {
        return senderId;
    }
    public String getReceiverId() {
        return receiverId;
    }
    public NotificationType getNotificationType() {
        return notificationType;
    }
    public String getContent() {
        return content;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public Notification(String senderId, String receiverId, Timestamp timestamp, NotificationType notificationType, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = timestamp;
        this.notificationType = notificationType;
        this.content = content;
    }

}
