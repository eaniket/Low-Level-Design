package ticTacToeGame.ticTacToeGame;

public class TicTacToeGameDemo {
    public static void run(){

        //Create players
        Player player1 = new Player("John", Sign.CROSS);
        Player player2 = new Player("Sam", Sign.ZERO);

        //This will make the system a single game at a time.
        //To allow multiple games, remove the singleton pattern from here.
        Game game = Game.getInstance(player1, player2);

        //Start game
        game.start();

    }
 public static void main(String[] args) {
    run();
 }
}
