package stackOverflow.stackOverflow;

public class Tag {
    private int id;
    private String name;

    public Tag(String name){
        this.id = generateId();
        this.name = name;
    }

    public int generateId(){
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
}
