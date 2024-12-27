package stackOverflow.stackOverflow;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private User author;
    private Date creationDate;

    public Comment(User user, String content){
        this.id = generateId();
        this.author = user;
        this.content = content;
        this.creationDate = new Date();
    }


    public int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

        // Getters
        public int getId() { return id; }
        public User getAuthor() { return author; }
        public String getContent() { return content; }
        public Date getCreationDate() { return creationDate; }
}
