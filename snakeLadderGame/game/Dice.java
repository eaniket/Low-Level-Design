package snakeLadderGame.game;

public class Dice {
    private final Integer faces;

    public Dice(Integer faces){
        this.faces = faces;
    }

    public Integer getNumber(){
        int randomNumber = (int)Math.ceil(Math.random()*1000);
        return randomNumber%faces + 1;
    }
}
