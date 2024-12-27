package stackOverflow.stackOverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable{
    private int id;
    private String content;
    private User author;
    private Question question;
    private boolean isAccepted;
    private Date creationDate;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User user, Question question, String content){
        this.id = generateId();
        this.author = user;
        this.question = question;
        this.content = content;
        this.isAccepted = false;
        this.creationDate = new Date();
        comments = new ArrayList<>();
        votes = new ArrayList<>();
    }

    @Override
    public void vote(User user, int value){
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        // Vote newVote = new Vote(user, value);
        // if(!votes.contains(newVote){
        //     votes.add(newVote);
        //     author.updateReputation(value);
        // }

        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.updateReputation(value*2);
    }

     @Override
    public int getVoteCount(){
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    @Override
    public void addComment(Comment comment){
        if(!comments.contains(comment))
            comments.add(comment);
    }

    @Override
    public List<Comment> getComments(){
        return Collections.unmodifiableList(comments);
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(10);  // +10 reputation for accepted answer
    }

    public int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // Getters
    public int getId() { return id; }
    public User getAuthor() { return author; }
    public Question getQuestion() { return question; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public boolean isAccepted() { return isAccepted; }
}
