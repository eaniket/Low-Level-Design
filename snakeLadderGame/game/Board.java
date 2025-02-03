package snakeLadderGame.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static Board board;
    private List<Player> players;
    private Player currentPlayer;
    private Integer currentPlayerIdx;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private Dice dice;

    private Board(){
        this.players = new ArrayList<>();
        currentPlayerIdx = 0;
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        this.dice = new Dice(6);
        addSnakesAndLadders();
    };

    public synchronized static Board getInstance(){
        if(board == null){
            board = new Board();
        }
        return board;
    }

    public void registerPlayer(Player player){
        players.add(player);
    }

    public void play(){
        while(true){
            currentPlayer = players.get(currentPlayerIdx);
            Integer newPosition = currentPlayer.getPosition() + throwDice(); 
            if(snakes.containsKey(newPosition)){
                newPosition = snakes.get(newPosition);
            }else if(ladders.containsKey(newPosition)){
                newPosition = ladders.get(newPosition);
            }
            System.out.println("Move by: " + currentPlayer.getName() + " from: " + currentPlayer.getPosition() + " to: " + newPosition);
            currentPlayer.updatePosition(newPosition);
            if(currentPlayer.isWinner()){
                break;
            }
            currentPlayerIdx = (currentPlayerIdx + 1)%players.size();
        }
    }

    private Integer throwDice(){
        return dice.getNumber();
    }

    private void addSnakesAndLadders(){
        //random snakes
        snakes.put(16, 6);
        snakes.put(98, 2);
        snakes.put(34, 12);

        //random ladders
        ladders.put(10, 99);
        ladders.put(54, 72);
        ladders.put(27, 39);
    }    
}

