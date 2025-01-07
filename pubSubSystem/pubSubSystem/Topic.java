package pubSubSystem.pubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private String name;
    private Set<Subscriber> subscribers;

    public Topic(String name){
        this.name = name;
        subscribers = new CopyOnWriteArraySet<>();
    }

    public String getName(){
        return name;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public void publish(Message message){
        for(Subscriber subscriber: subscribers){
            subscriber.onMessage(message);
        }
    }
}
