package snakeLadderGame.game;

import java.util.UUID;

public class Player{
    private String id;
    private String name;
    private String emailId;
    private Level level;
    private final String markerId;
    private Integer position;

    public Player(String name, String emailId, Level level, String markerId) {
        this.id = generateId();
        this.name = name;
        this.emailId = emailId;
        this.level = level;
        this.markerId = markerId;
        this.position = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public Level getLevel() {
        return level;
    }

    public String getMarkerId() {
        return markerId;
    }

    public void updatePosition(Integer newPosition){
        position = newPosition;
    }

    public Integer getPosition() {
        return position;
    }

    public Boolean isWinner(){
        if(position >= 100){
            updatePosition(100);
            System.out.println(this.name + " won the game!");
            return true;
        }
        return false;
    }

    private String generateId(){
        return "PLYR_"+UUID.randomUUID();
    }
}
