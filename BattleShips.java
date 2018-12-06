
import java.util.Scanner;
import java.util.Arrays;
public class BattleShips{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        char[][] board = {
                {'-','-','-','-','-','-'},
                {'-','-','-','-','-','-'},
                {'-','-','-','-','-','-'},
                {'-','-','-','-','-','-'},
                {'-','-','-','-','-','-'},
                {'-','-','-','-','-','-'},
            };

        printBoard(board);
        int patrol = 0;
        int sunkPatrol = 0;
        int destroyer = 0;
        int sunkDestroyer = 0;
        int battleship = 0;
        int sunkBattleship = 0;

        while(sunkPatrol<1 || sunkDestroyer<1 || sunkBattleship<1){

            String guess = input.next(); 
            guess = guess.toUpperCase();
            int[][] hidden = {
                    { 2, 0, 0, 0, 0, 0 },
                    { 2, 0, 0, 0, 3, 0 },
                    { 0, 0, 0, 0, 3, 0 },
                    { 0, 0, 0, 0, 3, 0 },
                    { 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 4, 4, 4, 4 },
                };

            char bRowChar = guess.charAt(0);
            int bRowInt = bRowChar-'A';
            char bColChar = guess.charAt(1);
            int bColInt = Character.getNumericValue(bColChar-1);                
            int hiddenNumber = hidden[bRowInt][bColInt]; 

            if(hiddenNumber == 2){
                patrol++;
                if(patrol == 2){
                    sunkPatrol++;
                }
            }
            if(hiddenNumber == 3){
                destroyer++;
                if(destroyer == 3){
                    sunkDestroyer++;
                }
            }
            if(hiddenNumber == 4){
                battleship++;
                if(battleship == 4){
                    sunkBattleship++;
                }
            }                            
            if(hiddenNumber > 0){ 
                board[bRowInt][bColInt] = 'X';
            }
            else if(hiddenNumber == 0){
                board[bRowInt][bColInt] = 'O';
            }
            else{
                board[bRowInt][bColInt] = '-';
            }                            
            
            board = printBoard(board);
            
            if(board[bRowInt][bColInt] == 'X'){
                System.out.println("Hit");
            }
            else{
                System.out.println("Miss");
            }
            if(sunkPatrol == 1){
                System.out.println("Sunk Patrol Boat");
            }
            if(sunkDestroyer == 1){
                System.out.println("Sunk Destroyer");
            }
            if(sunkBattleship == 1){
                System.out.println("Sunk Battleship");
            }
        }
        if(sunkPatrol==1 && sunkDestroyer==1 && sunkBattleship==1){
            System.out.println("You Win!");
        }                
    }    

    public static char[][] printBoard(char[][] board){
        System.out.println('\u000C');
        System.out.println("  ENEMY"+"\n"); 
        System.out.print(" ");
        for(int i=1;i<=board.length;i++){
            System.out.print(i);
        }
        System.out.println();
        for(int row=0;row<board.length;row++){
            System.out.print(""+(char)('A'+row));
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
        System.out.print("Please enter guess: "); 
        return board;
    }
}
 