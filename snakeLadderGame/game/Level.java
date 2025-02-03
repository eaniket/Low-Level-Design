package snakeLadderGame.game;

public enum Level {
    NEWBIE(1000, 1500),
    PUPIL(1501, 2000),
    EXPERT(2001, 2500); 

    private final int low;
    private final int high;

    private Level(int low, int high){
        this.low = low;
        this.high = high;
    }  
    
    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
