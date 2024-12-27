package stackOverflow.stackOverflow;

import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {
    public static void run(){
        StackOverflow system = new StackOverflow();
        
        //Creating Users
        User alice = system.createUser("Alice", "alice@example.com");
        User bob = system.createUser("Bob", "bob@example.com");
        User charlie = system.createUser("Charlie", "charlie@example.com");

        //Alice asks a question
        Question javaQuestion = system.askQuestion(alice, "What is polymorphism?",
            "Can someone explain polymorphism in java with an example?",
            Arrays.asList("java", "oop")
        );

        //Bob answers Alice's question
        Answer bobAnswer = system.answerQuestion(bob, javaQuestion, 
            "Polymorphism in Java is the ability of an object to take on many forms...");

        //Charlie comments on the question
        system.addComment(charlie, javaQuestion, "Great question! I'm also interested in learning about this.");

        //Alice comments on bob's answer
        system.addComment(alice, bobAnswer, "Thanks for the explanation!");

        //Charlie votes on the question and answer
        system.voteQuestion(charlie, javaQuestion, 1);
        system.voteAnswer(charlie, bobAnswer, 1);

        //Alice accepts Bob's answer
        system.acceptAnswer(bobAnswer);

        // Print out the current state
        System.out.println("Question: " + javaQuestion.getTitle());
        System.out.println("Asked by: " + javaQuestion.getAuthor().getUserName());
        System.out.println("Tags: " + javaQuestion.getTags().stream().map(Tag::getName).reduce((a, b) -> a + ", " + b).orElse(""));
        System.out.println("Votes: " + javaQuestion.getVoteCount());
        System.out.println("Comments: " + javaQuestion.getComments().size());
        System.out.println("\nAnswer by " + bobAnswer.getAuthor().getUserName() + ":");
        System.out.println(bobAnswer.getContent());
        System.out.println("Votes: " + bobAnswer.getVoteCount());
        System.out.println("Accepted: " + bobAnswer.isAccepted());
        System.out.println("Comments: " + bobAnswer.getComments().size());

        System.out.println("\nUser Reputations:");
        System.out.println("Alice: " + alice.getReputation());
        System.out.println("Bob: " + bob.getReputation());
        System.out.println("Charlie: " + charlie.getReputation());

        //Search functionality
        System.out.println("Search result for java");
        List<Question> searchResult = system.searchQuestions("java");
        for(Question q: searchResult){
            System.out.println(q.getTitle());
        }

        //Search functionality for questions by a user
        System.out.println("Alice's question");
        List<Question> bobQuestions = system.getQuestionsByUser(alice);
        for(Question q: bobQuestions){
            System.out.println(q.getTitle());
        }
    }

    public static void main(String args[]){
        
        run();
    }
}
