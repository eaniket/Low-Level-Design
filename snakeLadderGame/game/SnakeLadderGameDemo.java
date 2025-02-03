package snakeLadderGame.game;

public class SnakeLadderGameDemo {
    public static void run(){
        Board board = Board.getInstance();
        Marker marker1 = new Marker(Color.RED);
        Player player1 = new Player("John", "john@gmail.com", Level.NEWBIE, marker1.getMarkerId());
        Marker marker2 = new Marker(Color.YELLOW);
        Player player2 = new Player("Sam", "sam@gmail.com", Level.NEWBIE, marker2.getMarkerId());
        
        board.registerPlayer(player1);
        board.registerPlayer(player2);

        board.play();
    }
    public static void main(String[] args) {
        run();
    }
}





