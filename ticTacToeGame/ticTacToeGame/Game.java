package ticTacToeGame.ticTacToeGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Game game;
    private Board board;
    private Player player1;
    private Player player2;
    private int currentPlayer;

    private Game(Player player1, Player player2){
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = 0;
    }

    public static synchronized Game getInstance(Player player1, Player player2){
        if(game == null)
            game = new Game(player1, player2);
        return game;
    }

    private void showState(ArrayList<ArrayList<String>> board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private void move(){
        Player player = (currentPlayer % 2 == 0) ? player1 : player2;
        System.out.println("Current player " + player.getName() +", enter co-ordinates");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if(board.validate(x,y)){
            ArrayList<ArrayList<String>> currentBoard = board.getBoard();
            currentBoard.get(x).set(y, player.getSign().label);
            board.setBoard(currentBoard);
            showState(board.getBoard());
            currentPlayer++;

        }else{
            System.out.println("Invalid move, please enter again");
            move();
        }
    }

    private void end(int gameStatus, int currentPlayer){
        if(gameStatus == 1){
            System.out.println("Player 1 won!");
        }else if(gameStatus == 0){
            System.out.println("Player 2 won!");
        }else{
            System.out.println("Match ended in draw!");
        }
    }

    public void start(){
        int gameStatus = board.checkStatus(currentPlayer);
        while(gameStatus == 3){
            move();
            gameStatus = board.checkStatus(currentPlayer);
        }
        if(gameStatus == 0 || gameStatus == 1 || gameStatus == 2){
            end(gameStatus, currentPlayer);
        }
    }
}
