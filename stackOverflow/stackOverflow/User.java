package stackOverflow.stackOverflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private int id;
    private String userName;
    private String email;
    private int reputation;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int COMMENT_REPUATION = 1;
    private static final int QUESTION_REPUATION = 3;
    private static final int ANSWER_REPUATION = 5;

    public User(int id, String userName, String email){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content){
        Answer answer = new Answer(this, question, content);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content){
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUATION);
        return comment;
    }

    public synchronized void updateReputation(int value){
        this.reputation += value;
    }

    //Getters
    public int getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public int getReputation() { return reputation; }
    public List<Question> getQuestions() { return Collections.unmodifiableList(questions); }
    public List<Answer> getAnswers() { return Collections.unmodifiableList(answers); }
    public List<Comment> getComments() { return Collections.unmodifiableList(comments); }
}
