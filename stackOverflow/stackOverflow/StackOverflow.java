package stackOverflow.stackOverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*
 * Use concurrent hashmap for consistency
 */

public class StackOverflow {
    private Map<Integer, User> users;
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
    private Map<String, Tag> tags;

    public StackOverflow(){
        users = new ConcurrentHashMap<Integer, User>();
        questions = new ConcurrentHashMap<Integer, Question>();
        answers = new ConcurrentHashMap<Integer, Answer>();
        tags = new ConcurrentHashMap<String, Tag>();
    }

    public User createUser(String userName, String email){
        int id = users.size()+1;
        User user = new User(id, userName, email);
        users.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags){
        Question ques = user.askQuestion(title, content, tags);
        questions.put(ques.getId(), ques);
        for(Tag tag: ques.getTags()){
            this.tags.putIfAbsent(tag.getName(), tag);
        }
        return ques;
    }

    public Answer answerQuestion(User user, Question question, String content){
        Answer answer = user.answerQuestion(question, content);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content){
        return user.addComment(commentable, content);
    }

    public void voteQuestion(User user, Question question, int value){
        question.vote(user, value);
    }

    public void voteAnswer(User user, Answer answer, int value){
        answer.vote(user, value);
    }

    public void acceptAnswer(Answer answer){
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query){
        return questions.values().stream()
            .filter(q-> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query))
            )
            .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user){
        return user.getQuestions();
    }

    //Getters
    public User getUser(int id) {return users.get(id);}
    public Question getQuestion(int id) {return questions.get(id);}
    public Answer getAnswer(int id) {return answers.get(id);}
    public Tag getTag(String tag) {return tags.get(tag);}

}

