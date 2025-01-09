package ticTacToeGame.ticTacToeGame;

public enum Sign {
    CROSS("X"),
    ZERO("O");

    public final String label;
    private Sign(String label){
        this.label = label;
    }
    
};
