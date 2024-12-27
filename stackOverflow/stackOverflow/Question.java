package stackOverflow.stackOverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Votable{
    private int id;
    private String title;
    private String content;
    private User author;
    private Date creationDate;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;

    public Question(User user, String title, String content, List<String> tags){
        this.id = generateId();
        this.title = title;
        this.content = content;
        this.author = user;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.tags = new ArrayList<>();
        for(String tagName: tags){
            Tag newTag = new Tag(tagName);
            this.tags.add(newTag);
        }
    }

    public void addAnswer(Answer answer){
        if(!answers.contains(answer))
            answers.add(answer);
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
        author.updateReputation(value);
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

    public int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    //Getter
    public int getId() { return id; }
    public User getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Date getCreationDate() { return creationDate; }
    public List<Answer> getAnswers() { return new ArrayList<>(answers); }
    public List<Tag> getTags() { return new ArrayList<>(tags); }

}
