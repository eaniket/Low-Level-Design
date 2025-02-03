package snakeLadderGame.game;

import java.util.UUID;

public class Marker {
    private final String markerId;
    private Integer playerId;
    private Color color;

    public String getMarkerId() {
        return markerId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public Color getColor() {
        return color;
    }

    public Marker(Color color){
        this.markerId = generateId();
        this.color = color;
    }

    private String generateId(){
        return "MKR_"+UUID.randomUUID();
    }
}
