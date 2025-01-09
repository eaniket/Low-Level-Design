package ticTacToeGame.ticTacToeGame;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<String>> board;
    private Integer filledBoxes;

    public Board(){
        this.board = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add("-");
            }
            board.add(row);
        }
        this.filledBoxes = 0;
    }

    public ArrayList<ArrayList<String>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<String>> newboard){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board.get(i).set(j, newboard.get(i).get(j));
            }
        }
    }

    private boolean checkRows(){
        for(int i=0;i<3;i++){
            if(board.get(i).get(0) != "-" && board.get(i).get(0) == board.get(i).get(1) 
            && board.get(i).get(1) == board.get(i).get(2))
                return true;
        }
        return false;
    }

    private boolean checkColumns(){
        for(int i=0;i<3;i++){
            if(board.get(0).get(i) != "-" && board.get(0).get(i) == board.get(1).get(i) 
            && board.get(1).get(i) == board.get(2).get(i))
                return true;
        }
        return false;
    }

    private boolean checkDiagonals(){
        if(
            (board.get(0).get(0) != "-" && board.get(0).get(0) == board.get(1).get(1)
            && board.get(1).get(1) == board.get(2).get(2))
            || (board.get(0).get(2) != "-" && board.get(0).get(2) == board.get(1).get(1)
            && board.get(1).get(1) == board.get(2).get(0))
        )
            return true;
        return false;
    }

    public int checkStatus(int currentPlayer){
        if(checkRows() || checkColumns() || checkDiagonals()){
            return currentPlayer%2;
        }
        if(filledBoxes == 9){
            return 2;
        }
        return 3;
    }

    public boolean validate(int x, int y){
        if(x>=0 && x<3 && y>=0 && y<3 
            && !board.get(x).get(y).equals("X") 
            && !board.get(x).get(y).equals("O") 
        ){
            filledBoxes += 1;
            return true;
        }
        return false;
    }
}
