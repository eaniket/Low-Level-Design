package pubSubSystem.pubSubSystem;

public class ConsoleSubscriber implements Subscriber{
    private String name;

    public ConsoleSubscriber(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void onMessage(Message message){
        System.out.println("Subscriber: " + name + "; message:" + message.getContent());
    }
}
