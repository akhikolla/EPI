
public class SudokuSolver {
	  private static final char EMPTY_ENTRY = '.';
	  public static char board[][] = new char[9][9];
	  public static void main(String[] args) {
		   for(int i = 0 ; i < 9 ; i++) {
			   for(int j = 0; j < 9 ; j++) {
				   board[i][j] = '.';
			   }   
		   }
		   board[0][0] = '5';
		   board[0][1] = '3';
		   board[0][4] = '7';
		   board[1][0] = '6';
		   board[1][3] = '1';
		   board[1][4] = '9';
		   board[1][5] = '5';
		   board[2][1] = '9';
		   board[2][2] = '8';
		   board[2][7] = '6';
		   board[3][0] = '8';
		   board[4][0] = '4';
		   board[5][0] = '7';
		   board[3][4] = '6';
		   board[4][3] = '8';
		   board[4][5] = '3';
		   board[5][4] = '2';
		   board[3][8] = '3';
		   board[4][8] = '1';
		   board[5][8] = '6';
		   board[6][1] = '6';
		   board[6][6] = '2';
		   board[6][7] = '8';
		   board[7][3] = '4';
		   board[7][4] = '1';
		   board[7][5] = '9';
		   board[7][8] = '5';
		   board[8][4] = '8';
		   board[8][7] = '7';
		   board[8][8] = '9';
		   printboard();
		   //solveSudoku();
		   canSolveSudokuFromCell(0,0);
		   System.out.println("After solving\n");
		   printboard();
		   
	  }
	  public static void solveSudoku() {
	    canSolveSudokuFromCell(0, 0);
	    printboard();
	  }

	  private static boolean canSolveSudokuFromCell(int row, int col) {
	    if (col == board[row].length) {
	      col = 0;
	      row++;

	      if (row == board.length) {
	        return true;
	      }
	    }

	    // Skip entries already filled out. They already have a value in them.
	    if (board[row][col] != EMPTY_ENTRY) {
	      return canSolveSudokuFromCell(row, col + 1);
	    }

	    for (int value = 1; value <= board.length; value++) {
	    	// to convert from int to char '0'
	      char charToPlace = (char) (value + '0');
	      if (canPlaceValue(row, col, charToPlace)) {
	        board[row][col] = charToPlace;
	        if (canSolveSudokuFromCell(row, col + 1)) {
	          return true;
	        }
	        board[row][col] = EMPTY_ENTRY;
	      }
	    }

	    return false;
	  }

	  private static boolean canPlaceValue(int row, int col, char charToPlace) {
	    // Check column of the placement
	    for (char[] placementRow: board) {
	      if (charToPlace == placementRow[col]){
	        return false;
	      }
	    }

	    // Check row of the placement
	    for (int i = 0; i < board[row].length; i++) {
	      if (charToPlace == board[row][i]) {
	        return false;
	      }
	    }

	    // Check region constraints - get the size of the sub-box
	    int regionSize = (int) Math.sqrt(board.length);

	    int verticalBoxIndex = row / regionSize;
	    int horizontalBoxIndex = col / regionSize;

	    int topLeftOfSubBoxRow = regionSize * verticalBoxIndex;
	    int topLeftOfSubBoxCol = regionSize * horizontalBoxIndex;

	    for (int i = 0; i < regionSize; i++) {
	      for (int j = 0; j < regionSize; j++) {
	        if (charToPlace == board[topLeftOfSubBoxRow + i][topLeftOfSubBoxCol + j]) {
	          return false;
	        }
	      }
	    }

	    return true;
	  }
	  public static void printboard() {
		  for(int i = 0 ; i < 9 ; i++) {
			   for(int j = 0; j < 9 ; j++) {
				   if(j==0)System.out.print("| ");	
				   System.out.print(board[i][j]);
				   if(j== 2 || j == 5 || j== 8) System.out.print("!");else System.out.print("|");
			   }   
			   if(i == 2 || i == 5 || i == 8)
		  System.out.println("\n****************************");
			   else
		  System.out.println("\n----------------------------");
		 }
	  }
	 
	  
	}