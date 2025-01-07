package pubSubSystem.pubSubSystem;

public class pubSubSystemDemo {
    public static void run(){
        //Create topics
        Topic topic1 = new Topic("topic1");
        Topic topic2 = new Topic("topic2");

        //Create publishers
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        //Create subscribers
        Subscriber subscriber1 = new ConsoleSubscriber("Subscriber1");
        Subscriber subscriber2 = new ConsoleSubscriber("Subscriber2");
        Subscriber subscriber3 = new ConsoleSubscriber("Subscriber3");

        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic2);

        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);

        publisher1.publish(topic1, new Message("Message1 on topic1 from publisher1"));
        publisher1.publish(topic1, new Message("Message2 on topic1 from publisher1"));
        publisher1.publish(topic2, new Message("Message3 on topic2 from publisher1"));
        publisher2.publish(topic2, new Message("Message1 on topic2 from publisher2"));

        topic1.removeSubscriber(subscriber2);

        publisher1.publish(topic1, new Message("Message1 on topic1 from publisher1"));
        publisher1.publish(topic1, new Message("Message2 on topic1 from publisher1"));
        publisher1.publish(topic2, new Message("Message3 on topic2 from publisher1"));
        publisher2.publish(topic2, new Message("Message1 on topic2 from publisher2"));

    }

    public static void main(String[] args) {
        run();
    }
}
