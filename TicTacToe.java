import java.util.Scanner;

public class TicTacToe {
    
	public static int row,col;
	public static Scanner sc = new Scanner(System.in);
	public static char[][] gameBoard = new char[3][3];
	public static char val = 'X';
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 3 ; i++) {
			 for(int j = 0 ; j < 3 ; j++) {
				 gameBoard[i][j] =' '; 
			 }
			 }
		 play();
		 printBoard();
	}
	public static void play() {
		boolean play = true;
		printBoard();
		while(play) {
		   System.out.println("Please enter the row and column");
		   row = sc.nextInt() - 1;
		   col = sc.nextInt() - 1;
		   gameBoard[row][col] = val;
		   printBoard();
		   if(val == 'X') 
			   val = 'O';
		   else 
			   val = 'X';
		   if(Win(row,col)) {
			   play = false;
			   System.out.println("Game Over " + val + " won !!!");
			   break;
		   }
		  
		}
	}
	public static void printBoard() {
		System.out.println("\n----------");
		for(int i = 0 ; i < 3 ; i++) {
			 for(int j = 0 ; j < 3 ; j++) {
				 if(j==0)System.out.print("| ");
				 System.out.print(gameBoard[i][j] + "| ");
				 
			 }
			 System.out.println("\n----------");
		 }
	}
	
	public static boolean Win(int rmove,int cmove) {
		if((gameBoard[rmove][0] == val && gameBoard[rmove][1] == val && gameBoard[rmove][2] == val) ||
		   (gameBoard[0][cmove] == val && gameBoard[1][cmove] == val && gameBoard[2][cmove] == val) ||
		   (gameBoard[0][0] == val && gameBoard[1][1] == val && gameBoard[2][2] == val) ||
		   (gameBoard[0][2] == val && gameBoard[1][1] == val && gameBoard[2][0] == val))
			return true;
		return false;
	}
}
