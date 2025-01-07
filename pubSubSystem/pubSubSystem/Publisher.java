package pubSubSystem.pubSubSystem;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Flow.Subscriber;

public class Publisher {
    private final Set<Topic> topics;

    public Publisher(){
        this.topics = new HashSet<>();
    }

    public void registerTopic(Topic topic){
        topics.add(topic);
    }

    public void publish(Topic topic, Message message){
        if(!topics.contains(topic)){
            System.out.println("This publisher can't publish on topic: " + topic.getName());
            return;
        }
        topic.publish(message);
    }
}
