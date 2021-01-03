package dicegame;

import java.util.Scanner;
import java.util.Random;

public class Dicegame {
    static int playerTotal = 51;
    static int computerTotal = 51;
    static int diceTotal = 0;
    static int computerRoll = 0;
    static String playerName = "";
    static String winner = "none";
    
    public static void main(String[] args) {
        System.out.println("this is a simple game you start with a score of 51 and you roll three dice add their totals and take that away from your score.\n the winner is the first to reach 0.\n 0 must be made exactly or you will not score anything.\n the game will end as a tie if there is no winner after ten goes.\n  good luck.");
        Scanner scan = new Scanner (System.in);
        System.out.println("player what is your name?");
        playerName = scan.next();
        for(int i=0; i<10; i++){
            diceRoll();
            playerScore();
            if(playerTotal==0){
                winner = "player";
                break;
            }
            System.out.println("type y to continue");
            String next = scan.next();
            computerTurn();
            computerScore();
            if(computerTotal==0){
                winner = "computer";
                break;
            }
            System.out.println("type y to continue");
            next = scan.next();
        }
        if(winner.equals("player")){
            System.out.println("congratulations " + playerName + " you won the game");
        } 
        else if(winner.equals("computer")){
            System.out.println("comiserations " + playerName + " you lost this game, but feel free to try again");
        }else{
            System.out.println("the game was too long. game was tied");
        }
    }
    
    public static int diceRoll(){
        System.out.println(playerName + " it is your turn to roll the dice:");
        Random random = new Random();
        int dice1 = random.nextInt(6)+1;
        System.out.println(playerName + " your first roll is a " + dice1);
        int dice2 = random.nextInt(6)+1;
        System.out.println(playerName + " your second roll is a " + dice2);
        int dice3 = random.nextInt(6)+1;
        System.out.println(playerName + " your third roll is a " + dice3);
        diceTotal = dice1 + dice2 + dice3;
        System.out.println(playerName + " your score is " + diceTotal);
        return diceTotal;
        
    } 
    
    public static int playerScore(){
        if(diceTotal<=playerTotal){
            playerTotal = playerTotal - diceTotal;
        }else{
            System.out.println("that roll was too high to score any points");
        }
        if(playerTotal!=0&&playerTotal<3){
            playerTotal=playerTotal+3;
        }
        System.out.println(playerName + " you have a total of: " + playerTotal);
        return playerTotal;
    }
    
    public static int computerTurn(){
        System.out.println("it is the computer's turn to roll the dice:");
        Random random = new Random();
        int dice1 = random.nextInt(6)+1;
        System.out.println("the computer rolled a " + dice1);
        int dice2 = random.nextInt(6)+1;
        System.out.println("the computer rolled a " + dice2);
        int dice3 = random.nextInt(6)+1;
        System.out.println("the computer rolled a " + dice3);
        computerRoll = dice1 + dice2 + dice3;
        System.out.println("the computer scored: " + computerRoll);
        return computerRoll;
    }
    
    public static int computerScore(){
        if(computerRoll<=computerTotal){
            computerTotal = computerTotal - computerRoll;
        }else{
            System.out.println("the computer rolled a number too large to score any points from");
        }
        if(computerTotal!=0&&computerTotal<3){
            computerTotal=computerTotal+3;
        }
        System.out.println("the computer has a total of: " + computerTotal);
        return computerTotal;
    }
}
